package com.glacier.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * 测试guava限流
 *
 * @author glacier
 * @version v1.0.0
 * @Date 2017-09-24  15:37:48
 */
public class LimitDemo {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println("测试:每秒向桶中放入5个token,每次获取一个令牌,令牌等待时间");
        /* 每秒向桶中放入5个token */
        final RateLimiter limiter = RateLimiter.create(5);
        for (int i = 0; i < 20; i++) {
            /* 从桶中取出一个token */
            double waitTime = limiter.acquire();
            System.out.println(waitTime);
        }
    }

    private static void test2() {
        System.out.println("测试:每秒向桶中放入5个token,一次获取5个令牌,令牌等待时间");
         /* 每秒向桶中放入5个token */
        final RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire());
    }

    private static void test3() {
        System.out.println("测试:每秒向桶中放入5个token,缓冲时间1分钟,一次获取5个令牌,令牌等待时间");
         /* 每秒向桶中放入5个token */
        final RateLimiter limiter = RateLimiter.create(5, 1, TimeUnit.SECONDS);
        /*尝试从桶中获取token，获取不到则返回false*/
        boolean result = limiter.tryAcquire();
        if (result) {
            System.out.println("成功获取token");
        }

        /*从桶中获取token，只需等待10ms*/
        result = limiter.tryAcquire(10, TimeUnit.MILLISECONDS);
        if (result) {
            System.out.println("等待10ms,成功获取token");
        }

    }
}
