package com.study.util;


public class StringUtil {

    public static String getStrByNotNull(String str) {
        if (str == null) {
            return "";
        } else return str.trim();
    }

    public static String getStrByNotNull(Integer value) {
        if (value == null) {
            return "0";
        } else {
            return value.toString().trim();
        }
    }

    public static String getStrByNotNull(Long value) {
        if (value == null) {
            return "0";
        } else {
            return value.toString().trim();
        }
    }

    public static long getValueByNotNull(Long value) {
        if (value == null) {
            return 0;
        } else {
            return value;
        }
    }
}
