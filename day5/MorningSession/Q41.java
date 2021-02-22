package MorningSession;

public class Q41 {
static int j =20;
public static void main(String[] args) {
	Q41 a = new Q41();
	int i =10;
	a.method(i);
	System.out.println(i);
	System.out.println(j);
}

public void method(int x)
{
	x = x*2;
	j = j*2;
}

}
