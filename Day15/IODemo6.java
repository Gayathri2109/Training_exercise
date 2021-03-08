package Day15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class IODemo6 {
public static void main(String[] args) throws IOException {
	String s = "hello hello hello";
	PushbackInputStream pbs = new PushbackInputStream(new ByteArrayInputStream(s.getBytes()) );
	
	int c=0;
	while((c=pbs.read())!=-1) {
		if((char)c=='h') {
			//Moves back the cursor to h and makes it H...
			pbs.unread('H');
		}else {
			System.out.println((char)c);
		}
	}
}
}
