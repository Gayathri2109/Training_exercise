package Day8;

public class Q10Q11 {

public static void main(String[] args) {
		C c = new C();	
	}
}

class A{
		public A(int i) {
			System.out.println("Class A value : "+ i);
		}
	}

class B{
		public B(int j) {
			System.out.println("Class B value: "+ j);
		}
	}

class C extends A{
		B b = new B(10);
		public C() {
			super(10);
		}
		
		
}
