package com.glacier.core.utils.docx4j;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Docx4jPdfTest {

	private static String dir = "Z:\\ftp\\test";

	@Test
	public void convertDocxToPDFTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String wordPath = dir + File.separator +  "zyjwspb.docx";
		String pdfPath = dir + File.separator + "docx4j_" + sdf.format(new Date()) + ".pdf";

        Docx4jPdf.convertDocxToPDF(wordPath, pdfPath);
	}

	@Test
	public void convertDocxToHtmlTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String wordPath = dir + File.separator +  "zyjwspb.docx";
		String pdfPath = dir + File.separator + "docx4J_" + sdf.format(new Date()) + ".html";
		Docx4jPdf.convertDocxToHtml(wordPath, pdfPath);
	}
}
