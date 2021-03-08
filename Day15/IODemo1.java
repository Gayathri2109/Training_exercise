package Day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODemo1 {
	public static void main(String[] args) {
		new CopyCommand().copy("def.properties");
	}
}

class CopyCommand{
	public void copy(String filename){
		FileInputStream fis = null ;	
		FileOutputStream fos = null;
		
		try {
	
		fis = new FileInputStream(filename);
		fos = new FileOutputStream("copydef1.properties");
		
		
		//int letter;
//		while((letter = fis.read()) !=-1)
//		{
//			System.out.println((char)letter);	
//		}
		System.out.println("No of bytes...."+fis.available());
//		byte b[] = new byte[fis.available()];
//		while((letter = fis.read(b)) != -1) {
//			String s = new String(b);
//			System.out.println(s);
//			System.out.println("loop runs");
//		}
		
		int noOfBytesRead;
		byte b[] = new byte[35];
		while((noOfBytesRead = fis.read(b)) != -1) {
			String s = new String(b,0,noOfBytesRead);
			System.out.println(s);
			System.out.println("loop runs");
			fos.write(b,0,noOfBytesRead);
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();}
		finally {
			try {
			fis.close();
			fos.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
         	
     }
}