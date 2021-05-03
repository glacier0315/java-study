package com.glacier.core.utils.itextpdf;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImgPdfUtilsTest {

	@Test
	public void img2pdfTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String impPath = dir + "/12345.jpg";
		String pdfPath = dir + "/out/docx4J_" + sdf.format(new Date()) + ".pdf";
		ImgPdfUtils.img2pdf(new File(impPath), new File(pdfPath));
	}
}
