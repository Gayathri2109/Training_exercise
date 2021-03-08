package Day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerilizableDemo {
public static void main(String[] args) throws Exception {
	
	WriteToString wts = new WriteToString();
	wts.write("hello".getBytes());
	System.out.println(wts.read());
	
	saveObject(wts);
	wts.write("hello world".getBytes());
	System.out.println(wts.read());
	
	wts = retrievelastsavedObject();
	System.out.println(wts.read());
}
	public static void saveObject(WriteToString wts) throws Exception {
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mydata.dat"));
	oos.writeObject(wts);
    }
	
	
	public static WriteToString retrievelastsavedObject() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mydata.dat"));
		return (WriteToString)ois.readObject();
	    }
	
}

class WriteToString implements Serializable{
	
	//transient String str; - value is not saved....
	String str;
	public void write(byte b[]) {
		str = new String(b);
	}
	
	public String read() {
		return str;
	}
}
