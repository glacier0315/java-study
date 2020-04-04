package com.glacier.job;

import com.glacier.asny.AsyncTask;
import com.glacier.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/15 0015</pre>
 */
@Component
public class MyJob {

    @Autowired
    private AsyncTask asyncTask;

    @Scheduled(cron = "0/30 * * * * ? ")
    public void print() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println("运行定时任务\t" + calendar.getTime());
    }

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void doTask1() {
        System.out.println("测试异步doTask1！");
        long start = System.currentTimeMillis();
        Future<String> future =  asyncTask.doTask1();
        long end = System.currentTimeMillis();
        System.out.println("异步doTask1测试，耗时\t" + (end - start) + "毫秒！");
        try {
            System.out.println("doTask1 \t" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Scheduled(cron = "0 1/5 * * * ? ")
    public void doTask2() {
        System.out.println("测试异步doTask2！");
        long start = System.currentTimeMillis();
        Future<String> future = asyncTask.doTask2();
        long end = System.currentTimeMillis();
        System.out.println("异步doTask2测试，耗时\t" + (end - start) + "毫秒！");
        try {
            System.out.println("doTask2 \t" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Scheduled(cron = "0 2/5 * * * ? ")
    public void doTask3() {
        System.out.println("测试doTask3异步！");
        long start = System.currentTimeMillis();
        asyncTask.doTask3();
        long end = System.currentTimeMillis();
        System.out.println("异步doTask3测试，耗时\t" + (end - start) + "毫秒！");
    }


}
