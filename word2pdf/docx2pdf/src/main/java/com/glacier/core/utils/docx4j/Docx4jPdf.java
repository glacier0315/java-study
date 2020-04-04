package com.glacier.core.utils.docx4j;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.docx4j.Docx4J;
import org.docx4j.Docx4jProperties;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.model.fields.FieldUpdater;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;

/**
 * dox转pdfl工具类
 * 
 * @author redxun
 */
public class Docx4jPdf {

	/**
	 * docx文档转换为PDF
	 * 
	 * @param pdfPath
	 *            PDF文档存储路径
	 * @throws Exception
	 *             可能为Docx4JException, FileNotFoundException, IOException等
	 */
	public static void convertDocxToPDF(String docxPath, String pdfPath) {
		OutputStream os = null;
		WordprocessingMLPackage mlPackage = null;
		Mapper fontMapper = null;
		File docx = new File(docxPath);
		File pdf = new File(pdfPath);
		if (!pdf.getParentFile().exists()) {
			pdf.getParentFile().mkdirs();
		}
		try {
			// Load .docx or Flat OPC .xml
			mlPackage = WordprocessingMLPackage.load(docx);
			// Refresh the values of DOCPROPERTY fields 
			FieldUpdater updater = new FieldUpdater(mlPackage);
			updater.update(true);

			// String regex =
			// ".*(calibri|camb|cour|arial|times|comic|georgia|impact|LSANS|pala|tahoma|trebuc|verdana|symbol|webdings|wingding).*";
			// PhysicalFonts.setRegex(regex);
			// FieldUpdater updater = new FieldUpdater(mlPackage);
			// updater.update(true);

			fontMapper = new IdentityPlusMapper();
			fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
			fontMapper.put("宋体", PhysicalFonts.get("SimSun"));
			fontMapper.put("微软雅黑", PhysicalFonts.get("Microsoft Yahei"));
			fontMapper.put("黑体", PhysicalFonts.get("SimHei"));
			fontMapper.put("楷体", PhysicalFonts.get("KaiTi"));
			fontMapper.put("新宋体", PhysicalFonts.get("NSimSun"));
			fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
			fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
			fontMapper.put("宋体扩展", PhysicalFonts.get("simsun-extB"));
			fontMapper.put("仿宋", PhysicalFonts.get("FangSong"));
			fontMapper.put("仿宋_GB2312", PhysicalFonts.get("FangSong_GB2312"));
			fontMapper.put("幼圆", PhysicalFonts.get("YouYuan"));
			fontMapper.put("华文宋体", PhysicalFonts.get("STSong"));
			fontMapper.put("华文中宋", PhysicalFonts.get("STZhongsong"));
			mlPackage.setFontMapper(fontMapper);

			os = new FileOutputStream(pdfPath);
			System.out.println("Attempting to use XSL FO");
			
			FOSettings foSettings = Docx4J.createFOSettings();
			foSettings.setWmlPackage(mlPackage);
			foSettings.setFoDumpFile(
					new File(pdf.getParentFile().getPath() + File.separator + "Documento_modificato.fo"));
			Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

			if (mlPackage.getMainDocumentPart().getFontTablePart() != null) {
				mlPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
			}
			FileUtils.deleteQuietly(foSettings.getFoDumpFile());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

	/**
	 * 把docx转成html
	 * 
	 * @param docxFilePath
	 * @param htmlPath
	 * @throws Exception
	 */
	public static void convertDocxToHtml(String docxFilePath, String htmlPath) {

		WordprocessingMLPackage wordMLPackage = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			is = new FileInputStream(new File(docxFilePath));
			os = new FileOutputStream(htmlPath);

			wordMLPackage = Docx4J.load(is);

			HTMLSettings htmlSettings = Docx4J.createHTMLSettings();

			String imageFilePath = htmlPath.substring(0, htmlPath.lastIndexOf("/") + 1) + "/images";
			htmlSettings.setImageDirPath(imageFilePath);
			htmlSettings.setImageTargetUri("images");
			htmlSettings.setWmlPackage(wordMLPackage);

			Docx4jProperties.setProperty("docx4j.Convert.Out.HTML.OutputMethodXML", true);

			Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
		} catch (Docx4JException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(is);
		}

	}
}