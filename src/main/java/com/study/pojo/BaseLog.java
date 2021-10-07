package com.study.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    public Serializable log_id;

    public Long log_device_ip;

    public String log_device_ipv6;

    public Long dev_id;

    public Long time_stamp;

    public String dev_name;

    public Long log_type;

    public String sub_type;

    public Long mac = null;

    public Long date_time;

    public Timestamp dateTime;

    public String user_name;

    public Serializable getLog_id() {
        return log_id;
    }

    public void setLog_id(Serializable log_id) {
        this.log_id = log_id;
    }

    public Long getLog_device_ip() {
        return log_device_ip;
    }

    public void setLog_device_ip(Long log_device_ip) {
        this.log_device_ip = log_device_ip;
    }

    public String getLog_device_ipv6() {
        return log_device_ipv6;
    }

    public void setLog_device_ipv6(String log_device_ipv6) {
        this.log_device_ipv6 = log_device_ipv6;
    }

    public Long getDev_id() {
        return dev_id;
    }

    public void setDev_id(Long dev_id) {
        this.dev_id = dev_id;
    }

    public Long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
    }

    public Long getLog_type() {
        return log_type;
    }

    public void setLog_type(Long log_type) {
        this.log_type = log_type;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public Long getMac() {
        return mac;
    }

    public void setMac(Long mac) {
        this.mac = mac;
    }

    public Long getDate_time() {
        return date_time;
    }

    public void setDate_time(Long date_time) {
        this.date_time = date_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}