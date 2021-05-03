package com.glacier.core.utils.xdocreport;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author glacier
 * @version v1.0.0
 * @since <pre>2017/4/11 0011</pre>
 */
public class XdocreportutilsTest {

    private static String dir = "Z:\\ftp\\test";


    @Test
    public void docx2pdfTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
        String wordPath = dir + File.separator +  "zyjwspb.docx";
        String pdfPath = dir + File.separator + "xdocreport_" + sdf.format(new Date()) + ".pdf";

        Xdocreportutils.docx2pdf(wordPath, pdfPath);
    }
}
