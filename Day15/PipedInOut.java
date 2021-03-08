package Day15;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipedInOut {

	public static void main(String[] args) throws Exception {
		PipedReader read = new PipedReader();
		PipedWriter write = new PipedWriter(read);
		
		ExecutorService es;
		es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			try {
			int data = read.read();
			while(data!=-1) {
				System.out.print((char)data);
				data = read.read();
			}}catch (Exception e) {e.printStackTrace();}
		});
		
		es.execute(()->{
			try {
				write.write("I love my country".toCharArray());
			}catch (Exception e) {e.printStackTrace();}
		});
		
	}
}
