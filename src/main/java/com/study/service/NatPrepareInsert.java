package com.study.service;

import com.study.pojo.NatLog;
import com.study.util.StringUtil;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class NatPrepareInsert {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(NatPrepareInsert.class);
    public static final int perBatch = 5000;

    public static final String EG_NAT_NAME = "eg_nat202109";

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int insert(List<NatLog> natLogList) {
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
            for (int j = 0; j < natLogList.size(); j++) {
                NatLog natLog = natLogList.get(j);
                statement.setInt(1, 1);
                statement.setLong(2, StringUtil.getValueByNotNull(natLog.log_device_ip));
                statement.setString(3, StringUtil.getStrByNotNull(natLog.log_device_ipv6));
                statement.setLong(4, StringUtil.getValueByNotNull(natLog.dev_id));
                statement.setLong(5, StringUtil.getValueByNotNull(natLog.time_stamp));
                statement.setString(6, StringUtil.getStrByNotNull(natLog.dev_name));
                statement.setLong(7, StringUtil.getValueByNotNull(natLog.log_type));
                statement.setString(8, StringUtil.getStrByNotNull(natLog.sub_type));
                statement.setLong(9, StringUtil.getValueByNotNull(natLog.ip_protocol));
                statement.setLong(10, StringUtil.getValueByNotNull(natLog.app_protocol));
                statement.setString(11, StringUtil.getStrByNotNull(natLog.user_name));
                statement.setLong(12, StringUtil.getValueByNotNull(natLog.ori_src_ip));
                statement.setString(13, StringUtil.getStrByNotNull(natLog.ori_src_ipv6));
                statement.setLong(14, StringUtil.getValueByNotNull(natLog.ori_dst_ip));
                statement.setString(15, StringUtil.getStrByNotNull(natLog.ori_dst_ipv6));
                statement.setLong(16, StringUtil.getValueByNotNull(natLog.ori_src_port));
                statement.setLong(17, StringUtil.getValueByNotNull(natLog.ori_dst_port));
                statement.setLong(18, StringUtil.getValueByNotNull(natLog.rep_src_ip));
                statement.setString(19, StringUtil.getStrByNotNull(natLog.rep_src_ipv6));
                statement.setString(20, StringUtil.getStrByNotNull(natLog.rep_dst_ip));
                statement.setString(21, StringUtil.getStrByNotNull(natLog.rep_dst_ipv6));
                statement.setLong(22, StringUtil.getValueByNotNull(natLog.rep_src_port));
                statement.setLong(23, StringUtil.getValueByNotNull(natLog.rep_dst_port));
                statement.setLong(24, StringUtil.getValueByNotNull(natLog.ori_vrfid));
                statement.setLong(25, StringUtil.getValueByNotNull(natLog.rep_vrfid));
                statement.setLong(26, StringUtil.getValueByNotNull(natLog.ori_input_bytes));
                statement.setLong(27, StringUtil.getValueByNotNull(natLog.rep_input_bytes));
                statement.setLong(28, StringUtil.getValueByNotNull(natLog.die_time));
                statement.setLong(29, natLog.create_time);
                statement.setTimestamp(30, natLog.dateTime == null ? new Timestamp(System.currentTimeMillis()) : natLog.dateTime);
                statement.setString(31, "");
                statement.setString(32, "");
                statement.setLong(33, natLog.mac == null ? 0 : natLog.mac);
                statement.setString(34, "");
                statement.setString(35, "");
                statement.setString(36, "");
                statement.setString(37, StringUtil.getStrByNotNull(natLog.devMac));
                statement.addBatch();
            }
            longs = statement.executeLargeBatch();
            connect.commit();
            statement.clearBatch();
            Long allEnd = System.currentTimeMillis();
            logger.debug("insert {}，cost {}", natLogList.size(), allEnd - allStart);
        } catch (Exception e) {
            logger.error("nat insert fail {}", e.getMessage());
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
