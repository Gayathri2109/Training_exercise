import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class XMLToPDF {
public static void main(String[] args) throws Exception {
	
	SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
	SAXParser parser = factory.newSAXParser();
	parser.parse("D:\\Workspace\\CreateExcelFiles\\bill.xml", new MyHandler2());
  }
}

class MyHandler2 extends DefaultHandler{
	
	FileWriter fw;
	PdfWriter write;
	PdfDocument pdfdoc;
	Document doc;
	Table table;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Startdoc...");
		
		try {
			write = new PdfWriter("D:\\PdfFiles\\bill.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pdfdoc = new PdfDocument(write);
		doc = new Document(pdfdoc);
		
		
		float [] pointColumnWidths = {100F, 100F, 100F, 100F, 100F, 100F};   
	    table = new Table(pointColumnWidths);    
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Enddoc....sucessfully created");
		try {
			doc.add(table);             
			doc.close();
			pdfdoc.close();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch,start,length);
		table.addCell(new Cell().add(s)); 
	}
}
