package Day9.FridayFun;

public class Q25 {
public static void main(String[] args) {
	Relational r = new Relational();
	r.greatestRelational();
}
}

class Numbers{
	int a = 10;
	int b=20;
	int c = 30;
}

class Relational extends Numbers{

	public void greatestRelational()
	{
		if(a>b && a>c)
			System.out.println(a+ " is greatest");
		else if(b>a && b>c)
			System.out.println(b+ " is greates");
		else
			System.out.println(c+ " is greatest");
		
	}
}

