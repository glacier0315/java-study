package com.glacier.core.utils.wps;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wps2pdfTest {

	private static String dir = "Z:\\ftp\\test";

    @Test
	public void officeToPdfTest(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssssss");
		String wordPath = dir + File.separator +  "zyjwspb.docx";
		String pdfPath = dir + File.separator + "wps_" + sdf.format(new Date()) + ".pdf";

        Wps2pdf.officeToPdf(wordPath, pdfPath);
	}
}
