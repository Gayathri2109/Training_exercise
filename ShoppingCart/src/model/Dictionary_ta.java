package model;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][]= {
			{"username","பயனர்பெயர்"},
			{"password","அடையாளச் சொல்"},
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
