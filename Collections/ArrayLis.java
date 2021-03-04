package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayLis {
public static void main(String[] args) {
	List<String> list = new ArrayList();
	
	list.add("d");
	list.add("c");
	list.add("b");
	list.add("a");
	
	if(list.contains("s"))
		System.out.println("true");
	else
		System.out.println("false");
	
	//Memory gets wasted when it calculates get(i) everytime, so we go for for each....
	int size = list.size();
	for(int i=0;i<size;i++)
		System.out.println(list.get(i));
	
	for(String str:list)
		System.out.println(str);
	
	//Iterator - Used to iterate in the forward direction
	Iterator<String> it = list.iterator();
	while(it.hasNext())
		System.out.print(it.next()+" ");
	
	//Once used cannot be reused....
	while(it.hasNext())
		System.out.println(it.next());
	
	//ListIterator - Used to iterate in both forward and backward direction
	System.out.println();
	ListIterator<String > lt = list.listIterator();
	while(lt.hasNext())
		lt.next();
	System.out.println();
	while(lt.hasPrevious())
		System.out.print(lt.previous()+" ");
	
	Collections.sort(list);
	System.out.println(list);
	
	Collections.sort(list, (o1,o2)->{
		return o2.compareTo(o1);
	});
	System.out.println(list);

	
	
	
	
}
}
