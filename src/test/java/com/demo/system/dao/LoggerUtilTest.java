package com.demo.system.dao;

import com.demo.utils.LoggerUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtilTest {

    private Logger logger = LoggerFactory.getLogger(LoggerUtilTest.class);


    @Test
    public void testExceptionLogger() {
        try {
            String str = null;
            str.charAt(19);

        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.LoggerError(logger, "测试捕获异常并记录日志！", e);
        }


    }
}
