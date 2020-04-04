package com.glacier.asny;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * AsyncTask Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/15/2017</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doTask1()
     */
    @Test
    public void testDoTask1() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> future = asyncTask.doTask1();
        long end = System.currentTimeMillis();
        System.out.println("doTask1 耗时\t" + (end - start) + "毫秒");
        System.out.println(future);
    }

    /**
     * Method: doTask2()
     */
    @Test
    public void testDoTask2() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> future = asyncTask.doTask2();
        long end = System.currentTimeMillis();
        System.out.println("doTask2 耗时\t" + (end - start) + "毫秒");
        System.out.println(future);
    }

    /**
     * Method: doTask3()
     */
    @Test
    public void testDoTask3() throws Exception {
        long start = System.currentTimeMillis();
        asyncTask.doTask3();
        long end = System.currentTimeMillis();
        System.out.println("doTask3 耗时\t" + (end - start) + "毫秒");
    }

}
