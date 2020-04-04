package com.glacier.core.utils.xdocreport;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class Xdocreportutils {

	/**
	 * @param docxPath
	 *            输入的文件流
	 * @param pdfPath
	 *            输出的文件对象
	 * @return
	 * @function 利用Apache POI从输入的文件中生成PDF文件
	 */
	public static void docx2pdf(String docxPath, String pdfPath) {
		OutputStream out = null;
		InputStream in = null;
		File pdf = new File(pdfPath);
		if (!pdf.getParentFile().exists()) {
			pdf.getParentFile().mkdirs();
		}
		try {
			out = new FileOutputStream(pdf);
			in = new FileInputStream(new File(docxPath));
			// 创建PDF选项
			PdfOptions pdfOptions = PdfOptions.create();// .fontEncoding("windows-1250")
			docx2pdf(in, out, pdfOptions);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}

	}

	/**
	 * 利用Apache POI从输入的文件中生成PDF文件
	 * 
	 * @param in
	 *            输入的文件流
	 * @param out
	 *            输出的文件对象
	 * @param pdfOptions
	 */
	public static void docx2pdf(InputStream in, OutputStream out, PdfOptions pdfOptions) {

		// 从输入的文件流创建对象
		XWPFDocument document = null;
		try {
			document = new XWPFDocument(in);
			// 执行PDF转化
			PdfConverter.getInstance().convert(document, out, pdfOptions);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(document);
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}

	}
}
