import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLParser {

	
	//public static void main(String[] args) throws Exception {
	
	    public ArrayList getXmlContent(String str) throws FileNotFoundException {
	    	
		File xmlFile = new File(str);
        UsersXmlParser parser = new UsersXmlParser();
        ArrayList users = parser.parseXml(new FileInputStream(xmlFile));
        return users;
	}
}