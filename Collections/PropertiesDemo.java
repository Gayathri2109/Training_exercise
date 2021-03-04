package Collections;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class PropertiesDemo {
public static void main(String[] args)throws Exception {
	Properties prop=new Properties();
	// prop.put("a1", "hello");	
	prop.load(new FileInputStream("abc.properties"));
	Enumeration e=prop.elements();
	
	while(e.hasMoreElements()) {
		e.nextElement();
		String value2=prop.getProperty("user");
		String value3=prop.getProperty("password");
		System.out.println(value2 +"\n"+value3);
	}
	}
}