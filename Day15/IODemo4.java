package Day15;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IODemo4 {
public static void main(String[] args) throws IOException {
	String str = "Jack &copy and Jill went &copy; up the hill......";
	//one with &copy must be printed 
	//other one with &copy; must be symbol of copyright...
	
	ByteArrayInputStream  bis = new ByteArrayInputStream(str.getBytes());
	
	BufferedInputStream bfs = new BufferedInputStream(bis);
	
	
	System.out.println(bfs.markSupported());
	
	int c;
	boolean mark = false;
	while((c=bfs.read())!=-1) {
		switch((char) c) {
		case '&':{
			if(!mark) {
				bfs.mark(32);
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
					bfs.reset();
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
