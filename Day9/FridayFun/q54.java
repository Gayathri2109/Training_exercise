package Day9.FridayFun;

public class q54 {
public static void main(String[] args) {
		parent1 p = new parent1() {
			
			@Override
			public void display() {
				System.out.println(5);
				
			}
		};
		
		p.display();
	}
}

interface parent1{
	public void display();
}

