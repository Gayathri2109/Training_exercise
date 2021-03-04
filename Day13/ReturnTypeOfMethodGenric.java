package Day13;

public class ReturnTypeOfMethodGenric {

	//To accept any element and to return any type
	
	public <E> E getObject(E[] element)
	{
		for(E elements:element)
		{
			System.out.print(elements+" ");
		}
		System.out.println();
		return null;
	}
	
	public static void main(String[] args) {
		ReturnTypeOfMethodGenric obj = new ReturnTypeOfMethodGenric();
		obj.getObject(new String[] {"a","b","c"});
		obj.getObject(new Integer[] {1,2,3,4});
		
	}
}

class Test{
	
}
