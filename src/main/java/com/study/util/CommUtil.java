package com.study.util;

import com.study.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

@Component
public class CommUtil {

    private static final Logger logger = LoggerFactory.getLogger(CommUtil.class);

    private static LogService logService;

    @Resource
    public void setLogService(LogService logService) {
        CommUtil.logService = logService;
    }

    public static boolean bulkInsertData(String loadTableName, String loadFileName, String cols) {
        if (loadbcp2Mariadb(loadTableName, loadFileName, cols)) {// 事后删除
//            File file = new File(loadFileName);
//            file.delete();
            return true;
        } else {
            File file = new File(loadFileName);
            File dir = new File(file.getParent() + "/error/");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file.renameTo(new File(file.getParent() + "/error/" + file.getName()));
            return false;
        }
    }

    public static boolean loadbcp2Mariadb(String tableName, String fileName, String cols) {
        String sql = null;

        if (System.getProperty("os.name").toLowerCase().startsWith("win")) { // 支持win开发环境
            sql = "load data local infile '" + fileName + "' replace  into table "
                    + tableName + " fields terminated by '\t' " + cols + "";
        } else {
            sql = "load data local infile '" + fileName + "' replace into table "
                    + tableName + " fields terminated by '\t' " + cols + "";
        }

        return logService.exeSqlByRtByJdbc(sql);
    }
}
