package MorningSession;

public class Q35 {
public static void main(String[] args) {
	Q35 obj = new Q35();
	String s = new String("ello");
	obj.amethod(s);
}
public void amethod(String s)
{
	char c ='H';
	//c+= s;
	s = c+s;
	System.out.println(s);
}

}
