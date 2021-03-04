package Collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("hello");
		v.add("world");
		v.add("hai");
		
		System.out.println(v);
		
		Enumeration<String> e = v.elements();
		//After like declaring an iterator u will not be able to add anything in the list...
		Iterator<String> it = v.iterator();
		
		v.add("world");
		while(e.hasMoreElements())
			System.out.print(e.nextElement()+" ");
		
		
		
//		while(it.hasNext())
//			System.out.print(it.next()+" ");
		System.out.println();
		ListIterator<String> ll = v.listIterator(4);
		while(ll.hasPrevious())
			System.out.print(ll.previous()+" ");
		
		
	}
}
