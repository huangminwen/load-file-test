package com.study.storage;

import com.study.pojo.NatLog;
import com.study.stream.LoadDataInFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NatLogSaveThreadByStream implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NatLogSaveThreadByStream.class);

    public static final String EG_NAT_NAME = "eg_nat202109";

    public static final int MYSQL_BATCH = 20000;

    private static LoadDataInFileUtil loadDataInFileUtil;

    @Override
    public void run() {
        StringBuilder tableColumnValue = new StringBuilder();

        while (true) {
            for (int i = 0; i < MYSQL_BATCH; i++) {
                tableColumnValue.append("1").append('\t'); //log_id
                tableColumnValue.append("2.2.2.2").append('\t');
                tableColumnValue.append("2.2.2.2").append('\t');
                tableColumnValue.append(0).append('\t');
                tableColumnValue.append(1631868035).append('\t');
                tableColumnValue.append("elogTester").append('\t');
                tableColumnValue.append(16).append('\t');
                tableColumnValue.append("fpm").append('\t');
                tableColumnValue.append(17).append('\t');
                tableColumnValue.append(0).append('\t');
                tableColumnValue.append("user000015").append('\t');
                tableColumnValue.append("10.1.1.25").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("4317").append('\t');
                tableColumnValue.append("4317").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');//
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("10.1.1.11").append('\t');
                tableColumnValue.append("4317").append('\t');
                tableColumnValue.append("4317").append('\t');
                tableColumnValue.append("22").append('\t');
                tableColumnValue.append("22").append('\t');
                tableColumnValue.append(2547).append('\t');
                tableColumnValue.append(2547).append('\t');

                tableColumnValue.append("9686718").append('\t');
                tableColumnValue.append("9680580").append('\t');
                tableColumnValue.append("9680580").append('\t');
                tableColumnValue.append(StringUtils.EMPTY).append('\t'); //l_vrfname
                tableColumnValue.append(StringUtils.EMPTY).append('\t'); //g_vrfname
                tableColumnValue.append(StringUtils.EMPTY).append('\t');
                tableColumnValue.append(StringUtils.EMPTY).append('\t'); //sn
                tableColumnValue.append(StringUtils.EMPTY).append('\t');//`extendChar1` varchar(64) DEFAULT NULL,
                tableColumnValue.append(StringUtils.EMPTY).append('\t');//`extendChar2` varchar(64) DEFAULT NULL,
                tableColumnValue.append(StringUtils.EMPTY).append('\n');
            }
            loadDataInFileUtil.insertData(StringUtils.EMPTY, EG_NAT_NAME, NatLog.getColsFildName(), tableColumnValue, MYSQL_BATCH);
            tableColumnValue = new StringBuilder();
        }
    }

    @Resource
    public void setLoadDataInFileUtil(LoadDataInFileUtil loadDataInFileUtil) {
        this.loadDataInFileUtil = loadDataInFileUtil;
    }
}
