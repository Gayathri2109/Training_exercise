package model;

import java.util.ListResourceBundle;

public class Dictionary_hi extends ListResourceBundle{
	Object obj[][]= {
			{"username","उपयोगकर्ता नाम"},
			{"password","पासवर्ड"},
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
