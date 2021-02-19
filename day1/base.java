package day1;

public class base {

}
//protected  
class  base1 
{
	 String  Method() {
		 return  "Wow";
	 }
}

class  dervied{
	
	public  void  useD()
	{
		base1  z  =  new  base1();
	    System.out.println("base  says,"+  z.Method  ());
	}
}