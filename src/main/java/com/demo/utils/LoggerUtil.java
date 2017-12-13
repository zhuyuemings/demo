package com.demo.utils;

import org.slf4j.Logger;

public class LoggerUtil {
    public static void LoggerError(Logger logger, String msg, Exception exception) {
        logger.error("错误信息：" + msg);
        logger.error("异常信息：" + exception.toString());
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        if (stackTraceElements.length > 0) {
            logger.error("异常位置：" + stackTraceElements[0]);
        }
    }
}
