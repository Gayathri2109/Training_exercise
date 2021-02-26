package Day9.FridayFun;

//Area = pi*r2 + 2*pi*rh     
//Energy = mass (acceleration*height +velocity^2/2) 

public class Q23 {
public static void main(String[] args) {
System.out.println("Area: "+Area());
System.out.println("Energy: "+Energy());
}

public static double Area()
{
	final double pi = 3.14;
	int r = 5;
	int h = 10;
	double area;
	
	area = (pi*r*r) + (2*pi*r*h);
	return area;
	
}

public static double Energy()
{
	double energy;
	int mass = 200;
	int acc = 20;
	int height = 10;
	int velocity = 20;
	energy = mass * (acc*height + (velocity*velocity)/2);
	return energy;
}

}
