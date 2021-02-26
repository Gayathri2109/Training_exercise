package Day9.FridayFun;

public class Q48 {

	public static void main(String[] args) {
		int a1 = 10;
		int b1 = 10;
		float a2 = 6.6f;
		float b2 = 3.3f;
		Arithmetic1 obj = new Arithmetic1(a2);
		Arithmetic1 obj1 = new Arithmetic1(a1);
		Arithmetic1 obj2 = new Arithmetic1(a2, b2);
		Arithmetic1 obj3 = new Arithmetic1(a1, b1);
	}
}

	class Arithmetic1{
		public Arithmetic1(int a,int b) {
			System.out.println("Addition: "+ ((int)a+b));
		}
		
		public Arithmetic1(int a) {
			System.out.println("Subraction: "+ ((int)a-5));
		}
		
		public Arithmetic1(float a,float b) {
			System.out.println("Multiplication: "+ ((int)a/b));
		}
		
		public Arithmetic1(float a) {
			System.out.println("Division: "+ ((int)a/5));
		}
	}
