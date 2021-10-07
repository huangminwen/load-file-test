package com.study.pojo;

import com.study.util.StringUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NatLog extends BaseLog implements Serializable {

    public Long ip_protocol;

    public Long app_protocol;

    public Long ori_src_ip;

    public Long ori_dst_ip;

    public String ori_src_ipv6;

    public String ori_dst_ipv6;

    public Long ori_src_port;

    public Long ori_dst_port;

    public Long rep_src_ip;

    public Long rep_dst_ip;

    public String rep_src_ipv6;

    public String rep_dst_ipv6;

    public Long rep_src_port;

    public Long rep_dst_port;

    public Long ori_vrfid;

    public Long rep_vrfid;

    public Long ori_input_bytes;

    public Long rep_input_bytes;

    public Long die_time;

    public int create_time;

    public String l_vrfname;

    public String g_vrfname;

    public String devMac;

    public static String BCP_COL_NAME = null;

    public Long getIp_protocol() {
        return ip_protocol;
    }

    public void setIp_protocol(Long ip_protocol) {
        this.ip_protocol = ip_protocol;
    }

    public Long getApp_protocol() {
        return app_protocol;
    }

    public void setApp_protocol(Long app_protocol) {
        this.app_protocol = app_protocol;
    }

    public Long getOri_src_ip() {
        return ori_src_ip;
    }

    public void setOri_src_ip(Long ori_src_ip) {
        this.ori_src_ip = ori_src_ip;
    }

    public Long getOri_dst_ip() {
        return ori_dst_ip;
    }

    public void setOri_dst_ip(Long ori_dst_ip) {
        this.ori_dst_ip = ori_dst_ip;
    }

    public String getOri_src_ipv6() {
        return ori_src_ipv6;
    }

    public void setOri_src_ipv6(String ori_src_ipv6) {
        this.ori_src_ipv6 = ori_src_ipv6;
    }

    public String getOri_dst_ipv6() {
        return ori_dst_ipv6;
    }

    public void setOri_dst_ipv6(String ori_dst_ipv6) {
        this.ori_dst_ipv6 = ori_dst_ipv6;
    }

    public String getRep_src_ipv6() {
        return rep_src_ipv6;
    }

    public void setRep_src_ipv6(String rep_src_ipv6) {
        this.rep_src_ipv6 = rep_src_ipv6;
    }

    public String getRep_dst_ipv6() {
        return rep_dst_ipv6;
    }

    public void setRep_dst_ipv6(String rep_dst_ipv6) {
        this.rep_dst_ipv6 = rep_dst_ipv6;
    }

    public Long getOri_src_port() {
        return ori_src_port;
    }

    public void setOri_src_port(Long ori_src_port) {
        this.ori_src_port = ori_src_port;
    }

    public Long getOri_dst_port() {
        return ori_dst_port;
    }

    public void setOri_dst_port(Long ori_dst_port) {
        this.ori_dst_port = ori_dst_port;
    }

    public Long getRep_src_ip() {
        return rep_src_ip;
    }

    public void setRep_src_ip(Long rep_src_ip) {
        this.rep_src_ip = rep_src_ip;
    }

    public Long getRep_dst_ip() {
        return rep_dst_ip;
    }

    public void setRep_dst_ip(Long rep_dst_ip) {
        this.rep_dst_ip = rep_dst_ip;
    }

    public Long getRep_src_port() {
        return rep_src_port;
    }

    public void setRep_src_port(Long rep_src_port) {
        this.rep_src_port = rep_src_port;
    }

    public Long getRep_dst_port() {
        return rep_dst_port;
    }

    public void setRep_dst_port(Long rep_dst_port) {
        this.rep_dst_port = rep_dst_port;
    }

    public Long getOri_vrfid() {
        return ori_vrfid;
    }

    public void setOri_vrfid(Long ori_vrfid) {
        this.ori_vrfid = ori_vrfid;
    }

    public Long getRep_vrfid() {
        return rep_vrfid;
    }

    public void setRep_vrfid(Long rep_vrfid) {
        this.rep_vrfid = rep_vrfid;
    }

    public Long getOri_input_bytes() {
        return ori_input_bytes;
    }

    public void setOri_input_bytes(Long ori_input_bytes) {
        this.ori_input_bytes = ori_input_bytes;
    }

    public Long getRep_input_bytes() {
        return rep_input_bytes;
    }

    public void setRep_input_bytes(Long rep_input_bytes) {
        this.rep_input_bytes = rep_input_bytes;
    }

    public Long getDie_time() {
        return die_time;
    }

    public void setDie_time(Long die_time) {
        this.die_time = die_time;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getL_vrfname() {
        return l_vrfname;
    }

    public void setL_vrfname(String l_vrfname) {
        this.l_vrfname = l_vrfname;
    }

    public String getG_vrfname() {
        return g_vrfname;
    }

    public void setG_vrfname(String g_vrfname) {
        this.g_vrfname = g_vrfname;
    }

    public String getDev_mac() {
        return devMac;
    }

    public void setDev_mac(String devMac) {
        this.devMac = devMac;
    }

    public static String getColsFildName() {

        if (BCP_COL_NAME == null) {
//            BCP_COL_NAME = "(log_id,log_device_ip,log_device_ipv6,dev_id,time_stamp,dev_name,log_type,"
//                    + "sub_type,ip_protocol,app_protocol,user_name,ori_src_ip,ori_src_ipv6,ori_dst_ip,"
//                    + "ori_dst_ipv6,ori_src_port,Ori_dest_port,rep_src_ip,rep_src_ipv6,rep_dst_ip,"
//                    + "rep_dst_ipv6,rep_src_port,rep_dst_port,ori_vrfid,rep_vrfid,ori_input_bytes,"
//                    + "rep_input_bytes,die_time,create_time,date_time,l_vrfname,g_vrfname,mac,sn,"
//                    + "extendChar1,extendChar2)";
            BCP_COL_NAME = "(log_id,log_device_ip,log_device_ipv6,dev_id,time_stamp,dev_name,log_type,"
                    + "sub_type,ip_protocol,app_protocol,user_name,ori_src_ip,ori_src_ipv6,ori_dst_ip,ori_dst_ipv6,"
                    + "ori_src_port,Ori_dest_port,rep_src_ip,rep_src_ipv6,rep_dst_ip,rep_dst_ipv6,"
                    + "rep_src_port,rep_dst_port,ori_vrfid,rep_vrfid,ori_input_bytes,"
                    + "rep_input_bytes,die_time,create_time,date_time,l_vrfname,g_vrfname,mac,sn,"
                    + "extendChar1,extendChar2,log_device_mac)";
        }
        return BCP_COL_NAME;
    }

    public void getBcp(StringBuilder buf) {
        buf.append("1").append('\t'); //log_id
        buf.append(StringUtil.getStrByNotNull(this.log_device_ip)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.log_device_ipv6)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.dev_id)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.time_stamp)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.dev_name)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.log_type)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.sub_type)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ip_protocol)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.app_protocol)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.user_name)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_src_ip)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_src_ipv6)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_dst_ip)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_dst_ipv6)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_src_port)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_dst_port)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_src_ip)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_src_ipv6)).append('\t');//
        buf.append(StringUtil.getStrByNotNull(this.rep_dst_ip)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_dst_ipv6)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_src_port)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_dst_port)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_vrfid)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_vrfid)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.ori_input_bytes)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.rep_input_bytes)).append('\t');

        buf.append(StringUtil.getStrByNotNull(this.die_time)).append('\t');
        buf.append(StringUtil.getStrByNotNull(this.create_time)).append('\t');
        buf.append(this.dateTime == null ? new Timestamp(System.currentTimeMillis()) : this.dateTime).append('\t');
        buf.append("").append('\t'); //l_vrfname
        buf.append("").append('\t'); //g_vrfname
        buf.append(this.mac == null ? "\\N" : this.mac).append('\t');
        buf.append("").append('\t'); //sn
        buf.append("").append('\t');//`extendChar1` varchar(64) DEFAULT NULL,
        buf.append("").append('\t');//`extendChar2` varchar(64) DEFAULT NULL,
        buf.append(StringUtil.getStrByNotNull(this.devMac)).append('\t');
    }

    public String getValueString() {
        StringBuffer buf = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        buf.append(String.format("%d", 1)).append(','); //log_id
        buf.append("'" + StringUtil.getValueByNotNull(this.log_device_ip) + "'").append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.log_device_ipv6) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.dev_id))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.time_stamp))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.dev_name) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.log_type))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.sub_type) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ip_protocol))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.app_protocol))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.user_name) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_src_ip))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.ori_src_ipv6) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_dst_ip))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.ori_dst_ipv6) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_src_port))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_dst_port))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_src_ip))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.rep_src_ipv6) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_dst_ip))).append(',');
        buf.append("'" + StringUtil.getStrByNotNull(this.rep_dst_ipv6) + "'").append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_src_port))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_dst_port))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_vrfid))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_vrfid))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.ori_input_bytes))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.rep_input_bytes))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.die_time))).append(',');
        buf.append(String.format("%d", StringUtil.getValueByNotNull((long) this.create_time))).append(',');
        if (this.dateTime != null) {
            DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String format = sdf1.format(dateTime);
            buf.append(String.format("to_date('%s','yyyy-mm-dd hh24:mi:ss')", format)).append(',');
        } else {
            buf.append(String.format("to_date('%s','yyyy-mm-dd hh24:mi:ss')", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))).append(',');
        }
        buf.append("null").append(','); //l_vrfname
        buf.append("null").append(','); //g_vrfname
        buf.append(String.format("%d", StringUtil.getValueByNotNull(this.mac))).append(',');
        buf.append("null").append(','); //sn
        buf.append("null").append(',');//`extendChar1` varchar(64) DEFAULT NULL,
        buf.append("null").append(',');//`extendChar2` varchar(64) DEFAULT NULL,
        buf.append("'" + StringUtil.getStrByNotNull(this.devMac) + "'");
        return buf.toString();
    }
}
