package Day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class NumFormat {
public static void main(String[] args) {
	NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(new Locale("en","US"));
	int i = 10101011;
	
	int j = 2_3_567_48; //it is accepted...
	
	System.out.println(String.format("%s", numberFormatter.format(i)));
	System.out.println(numberFormatter.format(j));

	DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("en","US"));
	Date date = new Date();
	System.out.println(dateFormatter.format(date));
	
	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("d-MMM-YYYY",new Locale("en","US"));
	String currDate = LocalDate.now().format(dateTime);
	System.out.println(currDate);
	
}
}
