package CollectionsTest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Q16 {
public static void before() {
	Set set = new TreeSet();
	set.add("2");
	set.add("3");
	set.add("1");
	Iterator it = set.iterator();
	while (it.hasNext())
	System.out.print(it.next() + " ");
}
public static void main(String[] args) {
	Q16.before();
}
}