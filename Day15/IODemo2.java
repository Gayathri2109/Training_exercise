package Day15;

import java.io.FileReader;
import java.io.FileWriter;

public class IODemo2 {
public static void main(String[] args) {
	new CharStream().copy("def.properties");
}
}

class CharStream{
	public void copy(String filename)
	{
		FileReader read = null;
		FileWriter write = null;
		
		try{
			
			read = new FileReader(filename);
			write = new FileWriter("copydef2.properties");
			
			int noOfCharRead;
			char c[] = new char[3];
			while((noOfCharRead =  read.read(c))!=-1)
			{
				String s = new String(c,0,noOfCharRead);
				System.out.println(s);
				System.out.println("Loop runs");
				write.write(c,0,noOfCharRead);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			try {
			read.close();
			write.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}