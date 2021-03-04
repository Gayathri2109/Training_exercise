package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		//Set<String> myset = new HashSet<String>();
		Set<String> myset = new TreeSet<String>((o1,o2)->{return o2.compareTo(o1);});
		myset.add("hello");
		myset.add("world");
		myset.add("hello");
		myset.add("gayu");
		myset.add("darshu");
		
		System.out.println(myset);
		
		for(String str:myset)
			System.out.print(str+" ");
		System.out.println();
		Iterator<String> iter = myset.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		
	}
}
