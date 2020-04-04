package com.glacier.core.document;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/5/2 0002</pre>
 */
public class MsOfficeDocConverterTest extends SpringBootAppTest {
    @Autowired
    private Converter msOfficeDocConverter;

    @Test
    public void converterTest() {
        System.out.println("MsOfficeDocConverterTest.converterTest");
        String src = "D:\\cache\\zyjwspb.docx";
        String des = "D:\\cache\\" + System.currentTimeMillis() + ".pdf";
        msOfficeDocConverter.convert(src, des);
    }

    @Test
    public void converterTimesTest() {
        System.out.println("MsOfficeDocConverterTest.converterTimesTest");
        String src = "D:\\cache\\zyjwspb.docx";
        String des = null;
        for (int i = 0; i < 10; i++) {
            des = "D:\\cache\\" + System.currentTimeMillis() + ".pdf";
            msOfficeDocConverter.convert(src, des);
        }
    }
}
