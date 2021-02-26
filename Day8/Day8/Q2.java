package Day8;

public class Q2 {
	
	double real,img;
	public Q2(double real,double img) {
		this.img = img;
		this.real = real;
	}
	public static Q2 sum(Q2 c1,Q2 c2)
	{
		Q2 temp = new Q2(0, 0);
		temp.img = c1.img+c2.img;
		temp.real = c1.real+c2.real;
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		Q2 c1 = new Q2(5.5, 6);
		Q2 c2 = new Q2(6, 5);
		Q2 temp = sum(c1,c2);
		System.out.println("Sum is: "+temp.real + "+" + temp.img+"i");
	}

}



