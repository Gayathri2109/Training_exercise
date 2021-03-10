
import java.util.ArrayList;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XmlParsing {

	public XmlParsing() throws Exception {
	
	SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
	SAXParser parser = factory.newSAXParser();
	parser.parse("D:\\Workspace\\CreateExcelFiles\\bill.xml", new MyHandler2());
	
	}
}

class MyHandler2 extends DefaultHandler{
	
	static ArrayList<String> arr = new ArrayList<String>();
	
	public MyHandler2() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Startdoc...");
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End doc...");
	}
	@Override
	public void endDocument() throws SAXException {
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch,start,length);
		arr.add(s);
		//System.out.println(arr);
	}
	


}
