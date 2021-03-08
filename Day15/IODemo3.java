package Day15;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo3 {
public static void main(String[] args) {
	File file = new File("d:/temp");
	
	System.out.println("Path..."+ file.getAbsolutePath());
	System.out.println("NAme of the file..."+ file.getName());
	System.out.println("does the file exists...:");
	System.out.println(file.exists()?"yes":"No");
	System.out.println(file.canWrite());
	//System.out.println(file.isDirectory());
	//File destFile = new File("def.properties");
	//System.out.println();
	//file.renameTo(destFile);
	
	String s[] = file.list(new MyFilter("java"));
	for(String ss:s)
		System.out.println(ss);
	
	//filter the files
  }
}

class MyFilter implements FilenameFilter{
	String extension;
	public MyFilter(String extension) {
		this.extension = extension;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith("." +  extension);
	}
}