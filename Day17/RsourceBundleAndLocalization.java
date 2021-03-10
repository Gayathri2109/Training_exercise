package Day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class RsourceBundleAndLocalization {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("ta"));
		Locale loc = Locale.getDefault();
		System.out.println(loc);
		
		//from dictionary prop file
		ResourceBundle rb = ResourceBundle.getBundle("dictionary",loc);
		//from java class file
		ResourceBundle rb1 = ResourceBundle.getBundle("Day17.Dictionary",loc);
		System.out.println(rb1.getString("hello"));

	}

}
