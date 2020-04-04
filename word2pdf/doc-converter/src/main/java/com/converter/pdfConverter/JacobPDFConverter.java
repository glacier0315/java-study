package com.converter.pdfConverter;

import com.converter.utils.FileUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

import java.io.File;

public class JacobPDFConverter implements PDFConverter {
	private static final int wdFormatPDF = 17;
	private static final int xlTypePDF = 0;
	private static final int ppSaveAsPDF = 32;

	/**
	 * 将office转为pdf
	 * @param inputFile 绝对路径
	 * @param pdfFile 绝对路径
	 */
	public void convert2PDF(String inputFile, String pdfFile) {
		if(inputFile == null || inputFile.trim().length() == 0){
			return;
		}
		String suffix = FileUtils.getFileSufix(inputFile);
		File file = new File(inputFile);
		if (!file.exists()) {
			System.out.println("文件不存在！");
			return;
		}
		if (suffix.equals("pdf")) {
			System.out.println("PDF not need to convert!");
			return;
		}
		if (suffix.equals("doc") || suffix.equals("docx") || suffix.equals("txt")) {
			word2PDF(inputFile, pdfFile);
		} else if (suffix.equals("ppt") || suffix.equals("pptx")) {
			ppt2PDF(inputFile, pdfFile);
		} else if (suffix.equals("xls") || suffix.equals("xlsx")) {
			excel2PDF(inputFile, pdfFile);
		} else {
			System.out.println("文件格式不支持转换!");
		}
	}

	/**
	 * 将office转为pdf
	 * @param inputFile 绝对路径
	 */
	public void convert2PDF(String inputFile) {
		String pdfFile = FileUtils.getFilePrefix(inputFile) + ".pdf";
		convert2PDF(inputFile, pdfFile);
	}

	/**
	 * 将word转为pdf 
	 * @param inputFile 绝对路径
	 * @param pdfFile 绝对路径
	 */
	public static synchronized void word2PDF(String inputFile, String pdfFile) {
		ActiveXComponent app = null;
		Dispatch doc = null;
		try {
			// 初始化
			ComThread.InitSTA();
			// 打开word应用程序
			app = new ActiveXComponent("Word.Application");
			// 设置word不可见
			app.setProperty("Visible", false);
			// 获得word中所有打开的文档,返回Documents对象
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
			doc = Dispatch.call(docs, "Open", inputFile, false, true).toDispatch();
			// 方案1：调用Document对象的SaveAs方法，将文档保存为pdf格式.word保存为pdf格式宏，值为17
			// 方案1：调用Document对象的ExportAsFixedFormat方法，将文档保存为pdf格式.word保存为pdf格式宏，值为17
			Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (doc != null) {
				// 关闭文档
				Dispatch.call(doc, "Close");
			}
			if (app != null) {
				// 关闭word应用程序
				app.invoke("Quit");
			}
			ComThread.Release();
		}

	}
	/**
	 * 将excel转为pdf 
	 * @param inputFile 绝对路径
	 * @param pdfFile 绝对路径
	 */
	public static synchronized void excel2PDF(String inputFile, String pdfFile) {
		ActiveXComponent app = null;
		Dispatch excel = null;
		try {
			// 初始化
			ComThread.InitSTA();
			app = new ActiveXComponent("Excel.Application");
			app.setProperty("Visible", false);
			Dispatch excels = app.getProperty("Workbooks").toDispatch();
			excel = Dispatch.call(excels, "Open", inputFile, false, true).toDispatch();
			Dispatch.call(excel, "ExportAsFixedFormat", xlTypePDF, pdfFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (excel != null) {
				// 关闭文档
				Dispatch.call(excel, "Close");
			}
			if (app != null) {
				// 关闭应用程序
				app.invoke("Quit");
			}
			ComThread.Release();
		}
	}

	public static synchronized void ppt2PDF(String inputFile, String pdfFile) {
		ActiveXComponent app = null;
		Dispatch ppt = null;
		try {
			// 初始化
			ComThread.InitSTA();
			app = new ActiveXComponent("PowerPoint.Application");
			Dispatch ppts = app.getProperty("Presentations").toDispatch();

			ppt = Dispatch.call(ppts, "Open", inputFile, true, // ReadOnly
					true, // Untitled指定文件是否有标题
					false// WithWindow指定文件是否可见
			).toDispatch();

			Dispatch.call(ppt, "SaveAs", pdfFile, ppSaveAsPDF);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ppt != null) {
				// 关闭文档
				Dispatch.call(ppt, "Close");
			}
			if (app != null) {
				// 关闭word应用程序
				app.invoke("Quit");
			}
			ComThread.Release();
		}
	}

}
