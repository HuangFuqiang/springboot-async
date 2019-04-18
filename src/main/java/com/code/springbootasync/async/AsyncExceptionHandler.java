package com.code.springbootasync.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOOGER = LoggerFactory.getLogger(AsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        LOOGER.error("Async method has uncaught exception, params:{}" + Arrays.toString(params));

        if (ex instanceof AsyncException) {
            AsyncException asyncException = (AsyncException) ex;
            LOOGER.error("asyncException:"  + asyncException.getMessage());
        }

        LOOGER.error("Exception :", ex);
    }
}
