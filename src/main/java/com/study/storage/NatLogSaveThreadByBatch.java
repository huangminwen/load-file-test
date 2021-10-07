package com.study.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class NatLogSaveThreadByBatch implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(NatLogSaveThreadByBatch.class);

    public static final int MYSQL_BATCH = 2000;

    public static final String EG_NAT_NAME = "eg_nat202109";

    public static final String FILE_PATH = "/opt/inap/filedata/audit/loadfile/eg_nat202109-1632813678309-588228.tmp";
//    public static final String FILE_PATH = "D:\\opt\\inap\\filedata\\audit\\loadfile\\eg_nat202109-1632813678309-588228.tmp";

    private static JdbcTemplate jdbcTemplate;

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        NatLogSaveThreadByBatch.jdbcTemplate = jdbcTemplate;
    }

    public NatLogSaveThreadByBatch() {

    }

    public NatLogSaveThreadByBatch(int num) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                long start = System.currentTimeMillis();
                int total = this.insert();
                long end = System.currentTimeMillis();
                if (total == MYSQL_BATCH) {
                    logger.info("insert log " + MYSQL_BATCH + " , cost ：" + (end - start));
                } else {
                    logger.error("insert log fail");
                }
            } catch (Exception e) {
                logger.error("insert fail {}", e.getMessage());
            }
        }
    }

    public int insert() {
        Connection connect = null;
        PreparedStatement statement = null;
        long[] longs = null;
        try {
            connect = jdbcTemplate.getDataSource().getConnection();
            connect.setAutoCommit(false);
            Long allStart = System.currentTimeMillis();
            String sql = " INSERT  /*+append*/  INTO " + EG_NAT_NAME + "(log_id,log_device_ip,log_device_ipv6,dev_id,time_stamp,dev_name,log_type,sub_type," +
                    "ip_protocol,app_protocol,user_name,ori_src_ip,ori_src_ipv6,ori_dst_ip,ori_dst_ipv6,ori_src_port,Ori_dest_port,rep_src_ip,rep_src_ipv6," +
                    "rep_dst_ip,rep_dst_ipv6,rep_src_port,rep_dst_port,ori_vrfid,rep_vrfid,ori_input_bytes,rep_input_bytes,die_time,create_time,date_time," +
                    "l_vrfname,g_vrfname,mac,sn,extendChar1,extendChar2,log_device_mac)" +
                    "  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            statement = connect.prepareStatement(sql);
            for (int j = 0; j < MYSQL_BATCH; j++) {
                statement.setInt(1, 1);
                statement.setLong(2, 222);
                statement.setString(3, "1.1.1.1");
                statement.setLong(4, 1);
                statement.setLong(5, 123456);
                statement.setString(6, "test");
                statement.setLong(7, 16);
                statement.setString(8, "fpm");
                statement.setLong(9, 12);
                statement.setLong(10, 22);
                statement.setString(11, "test");
                statement.setLong(12, 123);
                statement.setString(13, "121313254");
                statement.setLong(14, 2256);
                statement.setString(15, "2142454");
                statement.setLong(16, 123);
                statement.setLong(17, 123);
                statement.setLong(18, 222);
                statement.setString(19, "1.1.1.1");
                statement.setString(20, "167837965");
                statement.setString(21, "");
                statement.setLong(22, 22);
                statement.setLong(23, 22);
                statement.setLong(24, 22);
                statement.setLong(25, 22);
                statement.setLong(26, 22);
                statement.setLong(27, 22);
                statement.setLong(28, 22);
                statement.setLong(29, 22);
                statement.setTimestamp(30, new Timestamp(11236));
                statement.setString(31, "");
                statement.setString(32, "");
                statement.setLong(33, 12336);
                statement.setString(34, "");
                statement.setString(35, "");
                statement.setString(36, "");
                statement.setString(37, "test");
                statement.addBatch();
            }
            longs = statement.executeLargeBatch();
            connect.commit();
            statement.clearBatch();
            Long allEnd = System.currentTimeMillis();
            logger.debug("insert {}，cost {}", MYSQL_BATCH, allEnd - allStart);
        } catch (Exception e) {
            logger.error("insert fail {}", e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (longs != null) {
            return longs.length;
        } else {
            return 0;
        }
    }

}
