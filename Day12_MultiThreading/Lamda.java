package Day12_MultiThreading;

public class Lamda {
public static void main(String[] args) {

	call((name)->{
		System.out.println("My name is "+ name);
	});
	
	String str = call1((name,i)->{
		return name + "......" + i;
	});
	
	System.out.println(str);
	
}
public static void call(Lam lam)
{
	lam.display("Gayathri Venkatesan...");
}

public static String call1(Lam2 lam)
{
	return lam.display("Hello World",10);
}
}

interface Lam{
	public void display(String str);
}

interface Lam2{
	public String display(String str,int i);
}