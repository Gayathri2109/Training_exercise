package Day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MomentoPattern {

	public static void main(String[] args) throws Exception, IOException {
		Laddu laddu = new Laddu();
		System.out.println("size of the original laddu...."+laddu.size);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oos.writeObject(laddu);
		
		laddu.size=5;
		System.out.println("Now the size...."+laddu.size);
	
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2= (Laddu)ois.readObject(); //deep copy
		
		
		System.out.println("Original laddu...."+laddu2.size);
		System.out.println("Modified laddu...."+laddu.size);
	}
}

class Laddu implements Serializable{
	int size = 10;
	
	public Laddu() {
		System.out.println("Laddu obj created....");
	}
	
}
