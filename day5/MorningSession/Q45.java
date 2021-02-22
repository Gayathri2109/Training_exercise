package MorningSession;

public class Q45 {

	public static void main(String[] args) {
		Q45 a= new Q45();
		a.method(a);
	}
	
	public void method(Q45 r)
	{
		int i =99;
		multi(r);
		System.out.println(i);
	}
	
	public void multi(Q45 r)
	{
		//r.i = r.i*2;
	}
}
