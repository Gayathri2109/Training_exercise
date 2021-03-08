package Day15;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

public class IODemo5 {
public static void main(String[] args) throws IOException {
	String str = "Jack &copy and Jill went &copy; up the hill......";
	//one with &copy must be printed 
	//other one with &copy; must be symbol of copyright...
		
	CharArrayReader car = new CharArrayReader(str.toCharArray());
	BufferedReader br = new BufferedReader(car);
	
	
	
	System.out.println(br.markSupported());
	
	int c;
	boolean mark = false;
	while((c=br.read())!=-1) {
		switch((char) c) {
		case '&':{
			if(!mark) {
				br.mark(32);
				mark = true;
			}break;
			
		}
		case ';':{
			if(mark) {
				System.out.print((char)169);
				mark = false;
			}break;
		}
		case ' ':{
			if(mark)
				{
					br.reset();
					mark = false;
					System.out.print("&");
				}
			else {
			System.out.print(" ");}
			break;
			
		}
		default:{
			if(!mark) {
				System.out.print((char)c);
			}
		}
		}
	}
}
}
