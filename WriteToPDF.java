package com.ansari.pdf;
//pdfbox-app-2.0.24.jar
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class WriteToPDF {

	public static void main(String[] args) {

		
		try {
			
			// Loading an existing document
			File file = new File("/Users/kaleem/Downloads/my.pdf");
			PDDocument doc = PDDocument.load(file);

			// Retrieving the pages of the document
			PDPage page = doc.getPage(0);
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true);

			// Begin the Content stream
			contentStream.beginText();

			// Setting the font to the Content stream
			contentStream.setFont(PDType1Font.COURIER, 10);

			// Setting the position for the line
			contentStream.newLineAtOffset(50, 100);

			String text = "MOHAMMAD KALEEM ANSARI";

			// Adding text in the form of string
			contentStream.showText(text);

			// Ending the content stream
			contentStream.endText();

			System.out.println("New Text Content is added in the PDF Document.");

			// Closing the content stream
			contentStream.close();

			// Saving the document
			doc.save(new File("/Users/kaleem/Downloads/your.pdf"));

			// Closing the document
			doc.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
