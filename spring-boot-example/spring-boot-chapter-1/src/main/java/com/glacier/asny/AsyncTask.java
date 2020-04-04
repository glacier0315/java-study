package com.glacier.asny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.concurrent.Future;

@Component
public class AsyncTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("mySimpleAsync")
    public Future<String> doTask1() {
        logger.info("Task1 started.");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        logger.info("Task1 finished, time elapsed: {} ms.", end - start);

        return new AsyncResult<>("Task1 accomplished!");
    }

    @Async("myAsync")
    public Future<String> doTask2() {
        logger.info("Task2 started.");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        logger.info("Task2 finished, time elapsed: {} ms.", end - start);

        return new AsyncResult<>("Task2 accomplished!");
    }


    @Async("myAsync")
    public void doTask3() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("开始异步\t" + calendar.getTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calendar = Calendar.getInstance();
        System.out.println("结束异步\t" + calendar.getTime());
    }
}  