package com.study.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class LoadDataInFileUtil {

    private static final Logger logger = LoggerFactory.getLogger(LoadDataInFileUtil.class);
    private Connection conn = null;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }

    private int bulkLoadFromInputStream(String loadDataSql,
                                        InputStream dataStream) throws SQLException, ClassNotFoundException {
        if (null == dataStream) {
            return 0;
        }

        conn = getConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = conn.prepareStatement(loadDataSql);
//            statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(loadDataSql);

//            mysql8
        /*if (statement.isWrapperFor(com.mysql.cj.jdbc.JdbcStatement.class)) {
            com.mysql.cj.jdbc.ClientPreparedStatement mysqlStatement = statement.unwrap(com.mysql.cj.jdbc.ClientPreparedStatement.class);
            mysqlStatement.setLocalInfileInputStream(dataStream);
            mysqlStatement.executeUpdate();
        }*/
//        mysql5
            if (statement.isWrapperFor(com.mysql.jdbc.Statement.class)) {
                com.mysql.jdbc.PreparedStatement mysqlStatement = statement.unwrap(com.mysql.jdbc.PreparedStatement.class);
                mysqlStatement.setLocalInfileInputStream(dataStream);
                result = mysqlStatement.executeUpdate();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return result;
    }

    public String assembleSql(String dataBaseName, String tableName, String columnName) {
//        String insertColumnName = StringUtils.join(columnName, ",");
//        String sql = "LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE " + dataBaseName + "." + tableName + " (" + insertColumnName + ")";
        String sql = "LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE " + tableName + columnName;
        return sql;
    }

    public int fastInsertData(String sql, StringBuilder builder) {
        int rows = 0;
        InputStream is = null;
        try {
            byte[] bytes = builder.toString().getBytes();
            is = new ByteArrayInputStream(bytes);
            //批量插入数据。
            long beginTime = System.currentTimeMillis();
            rows = bulkLoadFromInputStream(sql, is);
            long endTime = System.currentTimeMillis();
            logger.info(" LOAD DATA LOCAL INFILE :【insert" + rows + "to database，cost" + (endTime - beginTime) + "ms。】");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        return rows;
    }

    public void insertData(String dataBaseName, String tableName, String columns, StringBuilder tableColumnValue, int size) {
        String sql = assembleSql(dataBaseName, tableName, columns);
        int mainTableInsertRows = fastInsertData(sql, tableColumnValue);
        if (mainTableInsertRows != size) {
            logger.error("insert fail");
        }
    }

}