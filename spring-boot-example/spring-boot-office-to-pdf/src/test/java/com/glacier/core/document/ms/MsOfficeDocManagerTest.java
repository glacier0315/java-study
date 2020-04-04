package com.glacier.core.document.ms;

import com.glacier.core.document.SpringBootAppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/5/2 0002</pre>
 */
public class MsOfficeDocManagerTest extends SpringBootAppTest {

    @Autowired
    private MsOfficeDocManager msOfficeDocManager;


    @Test
    public void initTest() {
        System.out.println("MsOfficeDocManagerTest.initTest");
        System.out.println(msOfficeDocManager);
    }
}
