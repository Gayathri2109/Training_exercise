package CollectionsTest;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Q20 {

	
	public static void main(String[] args) {
		LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>();
		 
		//TreeSet<Turtle> t = new TreeSet<Turtle>();
		Turtle t1 = new Turtle(1);
		 Turtle t2 = new Turtle(2);
		 Turtle t3 = new Turtle(1);
			
		 t.add(t1);
		 t.add(t2);
		 t.add(t3);
		 
		 System.out.println(t.size());
	}
}

class Turtle {
	 int size;
	 public Turtle(int s) { size = s; }
//	 public boolean equals(Object o) { return (this.size == ((Turtle)o).size); }
//	 // insert code here
//	 public int hashCode() {
//		 return 3;
//	 }
}
