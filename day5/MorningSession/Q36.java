package MorningSession;

public class Q36 {
public static void main(String[] args) {
	Q36 q = new Q36();
	
}

public Q36() {
	// TODO Auto-generated constructor stub
	String s1 = "Java";
	String s2 = "java";
	
	//if(s1==s2)
	if(s1.equals(s2))
	{
	  System.out.println("True");
	}
	
	if(s1.equalsIgnoreCase(s2))
	{
		System.out.println("IgnoreCase");
	}

}
}
