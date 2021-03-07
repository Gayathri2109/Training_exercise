package CollectionsTest;

public class Q2 {
public static void main(String[] args) {
	Q2 q1 = new Q2();
	Q2 q2 = new Q2();
	
	System.out.println(q1.equals(q2));
	System.out.println(q1.hashCode()==q2.hashCode());
 }
}
