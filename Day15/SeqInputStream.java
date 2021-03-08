package Day15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class SeqInputStream {
public static void main(String[] args) throws IOException {
	String str="helloWorld    ";
	ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
	
	StringBufferInputStream sbis = new StringBufferInputStream("hello world hai");
	
	SequenceInputStream sis = new SequenceInputStream(bis, sbis);
	int c=0;
	while((c=sis.read())!=-1) {
		System.out.print((char)c);
	}
}
}
