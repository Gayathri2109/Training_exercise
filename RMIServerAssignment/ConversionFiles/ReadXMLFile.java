package ConversionFiles;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

  // public static void main(String argv[]) {

	public ArrayList<String> readXML(String file){
		
		ArrayList userList = new ArrayList();
    
		try {

    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {

    boolean bfname = false;
  

    public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("option")) {
            bfname = true;
        }

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfname) {
        	String str = new String(ch, start, length);
            System.out.println(str);
            userList.add(str);
            bfname = false;
        } }

     };

       saxParser.parse(file, handler);
       
       
 
     } catch (Exception e) {
       e.printStackTrace();
     }
		//System.out.println(userList);
		return userList;
   }

}