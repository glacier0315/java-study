package com.glacier.core.utils.poi;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class PoiPdf {

	/**
	 * @param docxPath
	 *            输入的文件流
	 * @param pdfPath
	 *            输出的文件对象
	 * @return
	 * @function 利用Apache POI从输入的文件中生成PDF文件
	 */
	public static void convertWithPOI(String docxPath, String pdfPath) {

		// 从输入的文件流创建对象
		XWPFDocument document = null;
		OutputStream out = null;
		InputStream in = null;
		File pdf = new File(pdfPath);
		try {
			if (!pdf.getParentFile().exists()) {
				pdf.getParentFile().mkdirs();
			}
			out = new FileOutputStream(pdf);
			in = new FileInputStream(new File(docxPath));
			document = new XWPFDocument(in);
			// 创建PDF选项
			PdfOptions pdfOptions = PdfOptions.create();// .fontEncoding("windows-1250")

			// 执行PDF转化
			PdfConverter.getInstance().convert(document, out, pdfOptions);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(document);
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}

	}
}
