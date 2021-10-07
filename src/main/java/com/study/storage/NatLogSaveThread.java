package com.study.storage;

import com.study.pojo.NatLog;
import com.study.service.NatPrepareInsert;
import com.study.util.CommUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NatLogSaveThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(NatLogSaveThread.class);

    public static final int MYSQL_BATCH = 20000;

    public static final String FILE_PATH = "/opt/inap/filedata/audit/loadfile/eg_nat202109-1632813678309-588228.tmp";
//    public static final String FILE_PATH = "D:\\opt\\inap\\filedata\\audit\\loadfile\\eg_nat202109-1632813678309-588228.tmp";

    public NatLogSaveThread() {

    }

    public NatLogSaveThread(int num) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                long start = System.currentTimeMillis();
                boolean flag = CommUtil.bulkInsertData(NatPrepareInsert.EG_NAT_NAME, FILE_PATH, NatLog.getColsFildName());
                long end = System.currentTimeMillis();
                if (flag) {
                    logger.info("insert log " + MYSQL_BATCH + " , cost ：" + (end - start));
                } else {
                    logger.error("insert log fail");
                }
            } catch (Exception e) {
                logger.error("insert fail {}", e.getMessage());
            }
        }
    }

}
