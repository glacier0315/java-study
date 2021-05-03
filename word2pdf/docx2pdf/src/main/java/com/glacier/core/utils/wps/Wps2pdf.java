package com.glacier.core.utils.wps;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class Wps2pdf {
	public final static String WORDSERVER_STRING = "KWPS.Application";
	public final static String PPTSERVER_STRING = "KWPP.Application";
	public final static String EXECLSERVER_STRING = "KET.Application";
	private static final int wdFormatPDF = 17;
	private static final int xlTypePDF = 0;
	private static final int ppSaveAsPDF = 32;

	/**
	 * @return 操作成功与否的提示信息. 如果返回 -1, 表示找不到源文件, 或url.properties配置错误; 如果返回 0,
	 *         则表示操作成功; 返回1, 则表示转换失败
	 */
	public static int officeToPdf(String sourceFile, String destFile) {
		File inputFile = new File(sourceFile);
		if (!inputFile.exists()) {
			return -1;// 找不到源文件, 则返回-1
		}
		// 如果目标路径不存在, 则新建该路径
		File outputFile = new File(destFile);
		if (!outputFile.getParentFile().exists()) {
			outputFile.getParentFile().mkdirs();
		}
		String extentionName = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
		if ("ppt".equalsIgnoreCase(extentionName) || "pptx".equalsIgnoreCase(extentionName)
				|| "wpt".equalsIgnoreCase(extentionName)) {
			ppt2pdf(sourceFile, destFile);
		} else if ("doc".equalsIgnoreCase(extentionName) || "docx".equalsIgnoreCase(extentionName)
				|| "wps".equalsIgnoreCase(extentionName)) {
			doc2pdf(sourceFile, destFile);
		} else if ("xls".equalsIgnoreCase(extentionName) || "xlsx".equalsIgnoreCase(extentionName)
				|| "et".equalsIgnoreCase(extentionName)) {
			excel2PDF(sourceFile, destFile);
		}
		return 0;
	}

	protected static boolean doc2pdf(String srcFilePath, String pdfFilePath) {
		ActiveXComponent pptActiveXComponent = null;
		ActiveXComponent workbook = null;
		try {
			ComThread.InitSTA();// 初始化COM线程
			pptActiveXComponent = new ActiveXComponent(WORDSERVER_STRING);// 初始化exe程序
			Variant[] openParams = new Variant[] { new Variant(srcFilePath), // filePath
					new Variant(true), new Variant(true)// readOnley
			};
			workbook = pptActiveXComponent.invokeGetComponent("Documents").invokeGetComponent("Open", openParams);
			workbook.invoke("SaveAs", new Variant(pdfFilePath), new Variant(wdFormatPDF));
			return true;
		} finally {
			if (workbook != null) {
				workbook.invoke("Close");
				workbook.safeRelease();
			}
			if (pptActiveXComponent != null) {
				pptActiveXComponent.invoke("Quit");
				pptActiveXComponent.safeRelease();
			}
			ComThread.Release();
		}
	}

	protected static boolean ppt2pdf(String srcFilePath, String pdfFilePath) {
		ActiveXComponent pptActiveXComponent = null;
		ActiveXComponent workbook = null;
		boolean readonly = true;
		try {
			ComThread.InitSTA();// 初始化COM线程
			pptActiveXComponent = new ActiveXComponent(PPTSERVER_STRING);// 初始化exe程序
			workbook = pptActiveXComponent.invokeGetComponent("Presentations").invokeGetComponent("Open",
					new Variant(srcFilePath), new Variant(readonly));
			workbook.invoke("SaveAs", new Variant(pdfFilePath), new Variant(ppSaveAsPDF));
			return true;
		} finally {
			if (workbook != null) {
				workbook.invoke("Close");
				workbook.safeRelease();
			}
			if (pptActiveXComponent != null) {
				pptActiveXComponent.invoke("Quit");
				pptActiveXComponent.safeRelease();
			}
			ComThread.Release();
		}
	}

	protected static boolean excel2PDF(String srcFilePath, String pdfFilePath) {
		ActiveXComponent et = null;
		Dispatch workbooks = null;
		Dispatch workbook = null;
		ComThread.InitSTA();// 初始化COM线程
		// ComThread.InitSTA(true);
		try {
			et = new ActiveXComponent(EXECLSERVER_STRING);// 初始化et.exe程序
			et.setProperty("Visible", new Variant(false));
			workbooks = et.getProperty("Workbooks").toDispatch();
			// workbook = Dispatch.call(workbooks, "Open",
			// filename).toDispatch();//这一句也可以的
			workbook = Dispatch
					.invoke(workbooks, "Open", Dispatch.Method, new Object[] { srcFilePath, 0, true }, new int[1])
					.toDispatch();
			// Dispatch.invoke(workbook,"SaveAs",Dispatch.Method,new
			// Object[]{pdfFilePath,xlTypePDF},new int[1]);
			Dispatch.call(workbook, "ExportAsFixedFormat", new Object[] { xlTypePDF, pdfFilePath });
			return true;
		} finally {
			if (workbook != null) {
				Dispatch.call(workbook, "Close");
				workbook.safeRelease();
			}
			if (et != null) {
				et.invoke("Quit");
				et.safeRelease();
			}
			ComThread.Release();
		}
	}

}
