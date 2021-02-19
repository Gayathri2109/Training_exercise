package day1;

public class Constant {
	public static void main(String[] args) {
		{
		Instances obj = new Instances(123);
		Instances obj1 = new Instances(456);
		System.out.println(obj.account);
		System.out.println(obj1.account);
		//obj.account = 15;
	}{
		Instances obj = new Instances(123);
		Instances obj1 = new Instances(456);
		obj.interest = 3.5f;
		obj1.interest = 4.5f;
		System.out.println(obj.interest);
		System.out.println(obj1.interest);
	}	
	{
		Instances obj = new Instances(123);
		Instances obj1 = new Instances(456);
		//obj.ODL_PRICE = 2000;
		//obj1.ODL_PRICE = 3000;
		System.out.println(obj.ODL_PRICE);
		System.out.println(obj1.ODL_PRICE);
	}
	} 

}

class Instances{
	
	Instances(int n)
	{
		account = n;
	}
	
	final int account;
	static float interest;
	static final int ODL_PRICE = 1000;
	
	
}
