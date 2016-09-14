package org.apache.pdfbox.text;

import org.apache.finance.pdfbox.text.PDFTextStripperWrapper;
import org.apache.finance.pdfbox.text.PdfTextProcessor;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class TestPdfTextProcessor {
	
	@Test
	public void testSearchUniqePageAndGetTextPositionList() {
		PdfTextProcessor processor;
		try {
			String keyword = "E.ON SE and Subsidiaries Consolidated Balance Sheets—Assets";
			processor = new PdfTextProcessor("http://www.eon.com/content/dam/eon-com/ueber-uns/publications/EON_Annual_Report_2015_EN.pdf");
			PDFTextStripperWrapper textStripper = processor.searchFistPageTextStripper(keyword);
			List<List<TextPosition>> textPositions = textStripper.getCharactersByArticle();
			textPositions.forEach(l -> {
				l.forEach(e -> {
					System.out.println("DEBUG::" + e.getUnicode());
				});
			});
			/*textPositions = processor.searchFirstTextPositionList(keyword);
			textPositions.forEach(l -> {
				l.forEach(e -> {
					System.out.println("DEBUG::" + e.getUnicode());
				});
			});*/
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<List<TextPosition>> pageContent = null;
//		try {
//			pageContent = this.processor.searchUniquePage("E.ON SE and Subsidiaries Consolidated Balance Sheets—Assets", it);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int[] index = {-1};
		/*
		List<TextPosition> textPositionList = this.processor.getTextPositionList("E.ON SE and Subsidiaries Consolidated Balance Sheets—Assets", pageContent, index);
		assertEquals("D", textPositionList.get(index[0]).toString());
		for (int i = index[0]; i < index[0]+500; i++) {
			TextPosition current = textPositionList.get(i);
			System.out.println(current + "[" + current.getX() + ", " + current.getY() + ", " + current.getWidth() + ", " + current.getXScale() + ", " + current.getFontSizeInPt() + "]");
		}*/
		
	}
}
