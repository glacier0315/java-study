package com.glacier.core.utils.itextpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class PdfUtilsTest {

	/**
	 * 创建pdf
	 */
	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfWriter writer = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			writer = PdfWriter.getInstance(document, out);

			document.open();
			// 页边空白
			document.setMargins(10, 20, 30, 40);
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			document.add(new Paragraph("Hello World"));

			writer.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 插入Chunk, Phrase, Paragraph, List
	 */
	@Test
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test1_" + sdf.format(new Date()) + ".pdf";
		String imgPath = dir + "/sy.jpg";
		Document document = null;
		try {
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			// 页边空白
			document.setMargins(10, 20, 30, 40);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			// PDF版本(默认1.4)
			// writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			// Chunk对象: a String, a Font, and some attributes
			document.add(new Chunk("China"));
			document.add(Chunk.NEWLINE);
			Font font = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
			Chunk id = new Chunk("chinese", font);
			id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
			id.setTextRise(6);
			document.add(id);
			document.add(Chunk.NEWLINE);

			document.add(new Chunk("Japan"));
			document.add(Chunk.NEWLINE);
			Font font2 = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
			Chunk id2 = new Chunk("japanese", font2);
			id2.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
			id2.setTextRise(6);
			id2.setUnderline(0.2f, -2f);
			document.add(id2);
			document.add(Chunk.NEWLINE);

			// Phrase对象: a List of Chunks with leading
			document.newPage();
			document.add(new Phrase("Phrase page"));

			Phrase director = new Phrase();
			Chunk name = new Chunk("China");
			name.setUnderline(0.2f, -2f);
			director.add(name);
			director.add(new Chunk(","));
			director.add(new Chunk(" "));
			director.add(new Chunk("chinese"));
			director.setLeading(24);
			document.add(director);

			Phrase director2 = new Phrase();
			Chunk name2 = new Chunk("Japan");
			name2.setUnderline(0.2f, -2f);
			director2.add(name2);
			director2.add(new Chunk(","));
			director2.add(new Chunk(" "));
			director2.add(new Chunk("japanese"));
			director2.setLeading(24);
			document.add(director2);

			// Paragraph对象: a Phrase with extra properties and a newline
			document.newPage();
			document.add(new Paragraph("Paragraph page"));

			Paragraph info = new Paragraph();
			info.add(new Chunk("China "));
			info.add(new Chunk("chinese"));
			info.add(Chunk.NEWLINE);
			info.add(new Phrase("Japan "));
			info.add(new Phrase("japanese"));
			document.add(info);

			// List对象: a sequence of Paragraphs called ListItem
			document.newPage();
			List list = new List(List.ORDERED);
			for (int i = 0; i < 10; i++) {
				ListItem item = new ListItem(String.format("%s: %d movies", "country" + (i + 1), (i + 1) * 100),
						new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));
				List movielist = new List(List.ORDERED, List.ALPHABETICAL);
				movielist.setLowercase(List.LOWERCASE);
				for (int j = 0; j < 5; j++) {
					ListItem movieitem = new ListItem("Title" + (j + 1));
					List directorlist = new List(List.UNORDERED);
					for (int k = 0; k < 3; k++) {
						directorlist.add(String.format("%s, %s", "Name1" + (k + 1), "Name2" + (k + 1)));
					}
					movieitem.add(directorlist);
					movielist.add(movieitem);
				}
				item.add(movielist);
				list.add(item);
			}
			document.add(list);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * 插入Anchor, Image, Chapter, Section
	 */
	@Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test2_" + sdf.format(new Date()) + ".pdf";
		String imgPath = dir + "/sy.jpg";
		Document document = null;
		try {
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			// 页边空白
			document.setMargins(10, 20, 30, 40);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			// PDF版本(默认1.4)
			// writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			document.newPage();
			// Anchor对象: internal and external links
			Paragraph country = new Paragraph();
			Anchor dest = new Anchor("china", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
			dest.setName("CN");
			dest.setReference("http://www.china.com");// external
			country.add(dest);
			country.add(String.format(": %d sites", 10000));
			document.add(country);

			document.newPage();
			Anchor toUS = new Anchor("Go to first page.",
					new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
			toUS.setReference("#CN");// internal
			document.add(toUS);

			// Image对象
			document.newPage();
			Image img = Image.getInstance(imgPath);
			img.setAlignment(Image.LEFT | Image.TEXTWRAP);
			img.setBorder(Image.BOX);
			img.setBorderWidth(10);
			img.setBorderColor(BaseColor.WHITE);
			img.scaleToFit(1000, 72);// 大小
			img.setRotationDegrees(-30);// 旋转
			document.add(img);

			// Chapter, Section对象（目录）
			document.newPage();
			Paragraph title = new Paragraph("Title");
			Chapter chapter = new Chapter(title, 1);

			title = new Paragraph("Section A");
			Section section = chapter.addSection(title);
			section.setBookmarkTitle("bmk");
			section.setIndentation(30);
			section.setBookmarkOpen(false);
			section.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);

			Section subsection = section.addSection(new Paragraph("Sub Section A"));
			subsection.setIndentationLeft(20);
			subsection.setNumberDepth(1);

			document.add(chapter);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * 目录
	 */
	@Test
	public void test3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test3_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		try {
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			// 页边空白
			document.setMargins(10, 20, 30, 40);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			// PDF版本(默认1.4)
			// writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			document.add(new Paragraph("Hello World"));

			// Code 1
			document.add(new Chunk("Chapter 1").setLocalDestination("1"));

			document.newPage();
			document.add(new Chunk("Chapter 2").setLocalDestination("2"));
			document.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));
			document.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));

			document.newPage();
			document.add(new Chunk("Chapter 3").setLocalDestination("3"));

			// Code 2
			PdfContentByte cb = writer.getDirectContent();
			PdfOutline root = cb.getRootOutline();

			// Code 3
			PdfOutline oline1 = new PdfOutline(root, PdfAction.gotoLocalPage("1", false), "Chapter 1");

			PdfOutline oline2 = new PdfOutline(root, PdfAction.gotoLocalPage("2", false), "Chapter 2");
			oline2.setOpen(false);

			PdfOutline oline2_1 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.1", false), "Sub 2.1");
			PdfOutline oline2_2 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.2", false), "Sub 2.2");

			PdfOutline oline3 = new PdfOutline(root, PdfAction.gotoLocalPage("3", false), "Chapter 3");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * Header, Footer
	 */
	@Test
	public void test4() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test4_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		try {
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			// 页边空白
			document.setMargins(10, 20, 30, 40);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			// PDF版本(默认1.4)
			writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			writer.setPageEvent(new PdfPageEventHelper() {

                @Override
                public void onEndPage(PdfWriter writer, Document document) {

                    PdfContentByte cb = writer.getDirectContent();
                    cb.saveState();

                    cb.beginText();
                    BaseFont bf = null;
                    try {
                        bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
                    } catch (Exception e) {
                        e.printStackTrace();
					}
					cb.setFontAndSize(bf, 10);

					// Header
					float x = document.top(-20);

					// 左
					cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "H-Left", document.left(), x, 0);
					// 中
					cb.showTextAligned(PdfContentByte.ALIGN_CENTER, writer.getPageNumber() + " page",
							(document.right() + document.left()) / 2, x, 0);
					// 右
					cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "H-Right", document.right(), x, 0);

					// Footer
					float y = document.bottom(-20);

					// 左
					cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "F-Left", document.left(), y, 0);
					// 中
					cb.showTextAligned(PdfContentByte.ALIGN_CENTER, writer.getPageNumber() + " page",
							(document.right() + document.left()) / 2, y, 0);
					// 右
					cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "F-Right", document.right(), y, 0);

					cb.endText();

					cb.restoreState();
				}
			});

			document.add(new Paragraph("1 page"));
			document.newPage();
			document.add(new Paragraph("2 page"));
			document.newPage();
			document.add(new Paragraph("3 page"));
			document.newPage();
			document.add(new Paragraph("4 page"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * 左右文字
	 */
	@Test
	public void test5() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test5_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		try {
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			// 页边空白
			document.setMargins(10, 20, 30, 40);

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			// PDF版本(默认1.4)
			// writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			PdfContentByte canvas = writer.getDirectContent();

			Phrase phrase1 = new Phrase("This is a test!left");
			Phrase phrase2 = new Phrase("This is a test!right");
			Phrase phrase3 = new Phrase("This is a test!center");
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase1, 10, 500, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase2, 10, 536, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase3, 10, 572, 0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * 合并PDF
	 */
	@Test
	public void test6() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdf1 = dir + "/cjjdb.pdf";
		String pdfPath = dir + "/out/test6_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfWriter writer = null;
		PdfReader reader = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			writer = PdfWriter.getInstance(document, out);

			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			reader = new PdfReader(pdf1);
			int totalPages = reader.getNumberOfPages();
			System.out.println("pdf总页数:\t" + totalPages);

			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage page = null;
			int pageOfCurrentReaderPDF = 0;
			while (pageOfCurrentReaderPDF < totalPages) {
				document.newPage();
				pageOfCurrentReaderPDF++;
				page = writer.getImportedPage(reader, pageOfCurrentReaderPDF);
				cb.addTemplate(page, 0, 0);
			}
			System.out.println(pageOfCurrentReaderPDF);

			writer.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test7() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String[] pdfs = { dir + "/cjjdb.pdf", dir + "/jxjsspb.pdf" };
		String pdfPath = dir + "/out/test7_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfWriter writer = null;
		PdfReader reader = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			writer = PdfWriter.getInstance(document, out);

			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			java.util.List<PdfReader> readers = new ArrayList<>();

			int totalPages = 0;
			for (String pdf : pdfs) {
				reader = new PdfReader(pdf);
				totalPages += reader.getNumberOfPages();
				readers.add(reader);
			}

			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage page = null;

			int pageOfCurrentReaderPDF = 0;
			int pages = 0;
			Iterator<PdfReader> it = readers.iterator();

			while (it.hasNext()) {
				reader = it.next();
				pages = reader.getNumberOfPages();
				while (pageOfCurrentReaderPDF < pages) {
					document.newPage();
					pageOfCurrentReaderPDF++;
					page = writer.getImportedPage(reader, pageOfCurrentReaderPDF);
					cb.addTemplate(page, 0, 0);
				}
				pageOfCurrentReaderPDF = 0;
			}
			System.out.println("pdf总页数:\t" + totalPages);
			System.out.println(pageOfCurrentReaderPDF);

			writer.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test8() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String[] pdfs = { dir + "/cjjdb.pdf", dir + "/jxjsspb.pdf" };
		String pdfPath = dir + "/out/test8_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfReader reader = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			PdfCopy copy = new PdfCopy(document, out);

			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			int totalPages = 0;
			PdfOutline root = copy.getRootOutline();
			PdfOutline oline = null;
			int i = 1;
			String chapter = "";
			for (String pdf : pdfs) {
				reader = new PdfReader(pdf);
				chapter = "Chapter " + i;
				oline = new PdfOutline(root, PdfAction.gotoLocalPage(String.valueOf(totalPages + 1), false), chapter);
				copy.addDocument(reader);
				copy.add(oline);

				totalPages += reader.getNumberOfPages();
				reader.close();
				i++;
			}
			System.out.println("pdf总页数:\t" + totalPages);

			copy.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test9() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String[] pdfs = { dir + "/cjjdb.pdf", dir + "/jxjsspb.pdf" };
		String pdfPath = dir + "/out/test9_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfReader reader = null;
		java.util.List<HashMap<String, Object>> outlines = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> outlineMap = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			PdfCopy copy = new PdfCopy(document, out);

			document.open();
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			int page = 1;
			for (String pdf : pdfs) {
				reader = new PdfReader(pdf);
				copy.addDocument(reader);

				outlineMap = new HashMap<String, Object>();
				outlineMap.put("Title", new File(pdf).getName());
				outlineMap.put("Action", "GoTo");
				outlineMap.put("Page", String.format("%d Fit", page));
				outlines.add(outlineMap);

				page += reader.getNumberOfPages();
				reader.close();
			}
			copy.setOutlines(outlines);
			System.out.println("pdf总页数:\t" + (page - 1));

			copy.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格嵌套
	 */
	@Test
	public void tets10() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssssss");
		String dir = System.getProperty("user.dir") + "/doc/test";
		String pdfPath = dir + "/out/test10_" + sdf.format(new Date()) + ".pdf";
		Document document = null;
		FileOutputStream out = null;
		PdfWriter writer = null;

		try {
			out = new FileOutputStream(pdfPath);
			// 页面大小
			Rectangle rect = new Rectangle(PageSize.A4);
			// 页面背景色
			rect.setBackgroundColor(BaseColor.WHITE);
			document = new Document(rect);
			writer = PdfWriter.getInstance(document, out);

			document.open();
			// 页边空白
			document.setMargins(10, 20, 30, 40);
			// 文档属性
			document.addTitle("Title@sample");
			document.addAuthor("Author@rensanning");
			document.addSubject("Subject@iText sample");
			document.addKeywords("Keywords@iText");
			document.addCreator("Creator@iText");

			PdfPTable table = new PdfPTable(4);

			// 1行2列
			PdfPTable nested1 = new PdfPTable(2);
			nested1.addCell("1.1");
			nested1.addCell("1.2");

			// 2行1列
			PdfPTable nested2 = new PdfPTable(1);
			nested2.addCell("2.1");
			nested2.addCell("2.2");

			// 将表格插入到指定位置
			for (int k = 0; k < 24; ++k) {
				if (k == 1) {
					table.addCell(nested1);
				} else if (k == 20) {
					table.addCell(nested2);
				} else {
					table.addCell("cell " + k);
				}
			}

			document.add(table);

			writer.flush();
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
