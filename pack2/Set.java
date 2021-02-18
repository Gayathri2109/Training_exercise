package pack2;

import pack3.Test1;

public class Set extends Test1{
	public void sum()
	{
	//System.out.println(s1);
	//System.out.println(s2);
	System.out.println(s3); //PROTECED
	System.out.println(s4); //PUBLIC
	}

}
class Set2{
	Test1 s = new Test1();
	
	public void sum()
	{
	//System.out.println(s.s1);
	//System.out.println(s.s2);
	//System.out.println(s.s3);
	System.out.println(s.s4); //PUBLIC
	}

}
