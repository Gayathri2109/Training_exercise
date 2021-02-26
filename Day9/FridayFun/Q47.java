package Day9.FridayFun;

public class Q47 {
public static void main(String[] args) {
	Arithmetic a = new Arithmetic();
	int a1 = 10;
	int b1 = 10;
	float a2 = 6.6f;
	float b2 = 3.3f;
	a.method(a2);
	a.method(a2, b2);
	a.method(a1, b1);
	a.method(a1);
}
}

class Arithmetic{
	public void method(int a,int b) {
		System.out.println("Addition: "+ ((int)a+b));
	}
	
	public void method(int a) {
		System.out.println("Subraction: "+ ((int)a-5));
	}
	
	public void method(float a,float b) {
		System.out.println("Multiplication: "+ ((int)a/b));
	}
	
	public void method(float a) {
		System.out.println("Division: "+ ((int)a/5));
	}
}