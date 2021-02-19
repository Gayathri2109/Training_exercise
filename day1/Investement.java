package day1;

public class Investement {
	public static void main(String[] args) {
		//multiplied by 70 for dollor conversion
		double d = 14000*70;
		double x,y,z;
		x = d+(0.4*14000*70);
		y = x - 1500;
		z = y+(0.12*y);
		
		double tot;
		if(z>d)
		  tot = z-d;
		else
		  tot = d-z;
		
		System.out.print("Total Profit: ");
		System.out.print("$"+ tot/70);
	}

}
