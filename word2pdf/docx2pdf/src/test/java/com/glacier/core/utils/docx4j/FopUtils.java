package com.glacier.core.utils.docx4j;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class FopUtils {

	public static void fo2pdf(String foPath, String pdfPath) {
		// Step 1: Construct a FopFactory
		// (reuse if you plan to render multiple documents!)
		FopFactory fopFactory = null;

		// Step 2: Set up output stream.
		// Note: Using BufferedOutputStream for performance reasons (helpful
		// with FileOutputStreams).
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(new File(pdfPath)));
			// Step 3: Construct fop with desired output format
			fopFactory = FopFactory.newInstance(new File(pdfPath));
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

			// Step 4: Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); // identity
																// transformer

			// Step 5: Setup input and output for XSLT transformation
			// Setup input stream
			Source src = new StreamSource(new File(foPath));

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Step 6: Start XSLT transformation and FOP processing
			transformer.transform(src, res);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FOPException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}

}
