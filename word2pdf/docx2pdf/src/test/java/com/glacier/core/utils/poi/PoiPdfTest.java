package com.glacier.core.utils.poi;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PoiPdfTest {

	private static String dir = "Z:\\ftp\\test";

	@Test
	public void convertWithPOITest(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String wordPath = dir + File.separator +  "zyjwspb.docx";
		String pdfPath = dir + File.separator + "poi_" + sdf.format(new Date()) + ".pdf";

		PoiPdf.convertWithPOI(wordPath, pdfPath);
	}

}
