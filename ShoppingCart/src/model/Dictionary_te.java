package model;

import java.util.ListResourceBundle;

public class Dictionary_te extends ListResourceBundle{
	Object obj[][]= {
			{"username","యూజర్ నేమ్"},
			{"password","పాస్ వర్డ్"},
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
