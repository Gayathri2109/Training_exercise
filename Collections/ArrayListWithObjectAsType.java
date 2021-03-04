package Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class ArrayListWithObjectAsType implements Comparable<ArrayListWithObjectAsType> {
	
	String name;
	public ArrayListWithObjectAsType(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: "+name;
	}
	
	@Override
	public int compareTo(ArrayListWithObjectAsType o) {
		
		return this.name.compareTo(o.name);
	}
	
public static void main(String[] args) {
	List<ArrayListWithObjectAsType> list = new ArrayList();
	
//	list.add(new ArrayListWithObjectAsType("Gayu"));
//	list.add(new ArrayListWithObjectAsType("Darshu"));
//	list.add(new ArrayListWithObjectAsType("Mummy"));
//	list.add(new ArrayListWithObjectAsType("Daddy"));
	
	list = Arrays.asList(new ArrayListWithObjectAsType("Gayu"),new ArrayListWithObjectAsType("Darshu"),new ArrayListWithObjectAsType("Mummy"),new ArrayListWithObjectAsType("Daddy"));
	
	Collections.sort(list);
	System.out.println(list);
	
	Collections.sort(list, (o1,o2)->{
		return o2.compareTo(o1);
	});
	System.out.println(list);
	
	Stream<ArrayListWithObjectAsType> s = list.stream();
	s.filter((emp)-> emp.name.equalsIgnoreCase("gayu")).forEach(System.out::println);
	
//	Stream<ArrayListWithObjectAsType> s= list.stream();
//	
//	s.filter((emp)->emp.name.equals("Gayu")).forEach(System.out::println);

	
	}
}
