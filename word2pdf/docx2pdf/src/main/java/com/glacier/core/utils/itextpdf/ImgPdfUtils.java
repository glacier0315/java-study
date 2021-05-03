package com.glacier.core.utils.itextpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class ImgPdfUtils {

	public static void img2pdf(File img, File pdf) {
		// 1：获取第一个Img的宽、高做为PDF文档标准
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		Document doc = null;
		PdfWriter pdfWr = null;
		try {
			is = new FileInputStream(img);
			baos = new ByteArrayOutputStream(2048 * 3);
			int len = 0;
			while ((len = is.read()) != -1) {
				baos.write(len);
			}
			baos.flush();

			Image image = Image.getInstance(baos.toByteArray());
			float width = image.getWidth();
			float height = image.getHeight();
			// 取消偏移量
			image.setAbsolutePosition(0f, 0f);
			// 2:通过宽高 ，实例化PDF文档对象。
			doc = new Document(new Rectangle(width + 50, height + 50));
			pdfWr = PdfWriter.getInstance(doc, new FileOutputStream(pdf));
			doc.open();
			doc.add(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			// 5：释放资源
			try {
				pdfWr.flush();
				baos.close();
				doc.close();
				pdfWr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
