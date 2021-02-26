package Day8;

public class Q9 {
public static void main(String[] args) {
	AA obj = new BB();
	((BB)obj).get();
}
}

class AA{
	private int i =10;
	protected int j = 20;
	public int k = 11;
			int m = 33;
			
	private void met()
	{
		System.out.println("Private Method");
	}
	
	protected void met1()
	{
		System.out.println("Protected Method");
	}
	
	public void met2()
	{
		System.out.println("Public Method");
	}
	
	 void met3()
	{
		System.out.println("No modifier Method");
	}
	
}

class BB extends AA{
	public void get()
	{
		//System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(m);
		
		//met();
		met1();
		met2();
		met3();
	}
		

}