package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LLDemo {
public static void main(String[] args) {
	List<String> ll = new LinkedList<String>();
	ll.add("gayu");
	ll.add("darhsu");
//	
//	System.out.println(ll);
//	
//	Iterator<String> it = ll.iterator();
//	while(it.hasNext())
//		System.out.println(it.next());
	
	ListIterator<String> it1 = ll.listIterator(2);
	while(it1.hasPrevious())
		System.out.println(it1.previous());
}
}
