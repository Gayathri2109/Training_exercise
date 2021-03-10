package ReadExcelFile;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLtoExcel {
public static void main(String[] args) throws Exception {
	
	SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
	SAXParser parser = factory.newSAXParser();
	parser.parse("bill.xml", new MyHandler1());
  }
}

class MyHandler1 extends DefaultHandler{
	
	FileOutputStream fileOut;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String filename = "D:\\Excelfiles\\xmlToexcel.xlsx";
	XSSFRow row;
	int i =0;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Startdoc...");
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Bill");
		row = sheet.createRow(0);
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		if(qName.equalsIgnoreCase("customername"))
//			row.createCell(0);
//		else if(qName.equalsIgnoreCase("item"))
//			row.createCell(1);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End of the doc....sucessfully created");
		try {
			fileOut = new FileOutputStream(filename);  
			workbook.write(fileOut);    
			fileOut.close();    
			workbook.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch,start,length);
	
		row.createCell(i).setCellValue(s);;
		i++;
	}
}
