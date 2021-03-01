package Day10;

public class PrototypePattern {
public static void main(String[] args) throws Throwable {
	
	//Multiton (there is no need to create a duplicate structure when u already have an structure
	/*Sheep s1 = new Sheep();
	s1.name = "Sheep1";
	Sheep s2 = new Sheep();
	s2.name = "Sheep2";
	
	System.out.println("Sheep 1....:"+s1.name);
	System.out.println("Sheep 2....:"+s2.name);
	*/
	
	
	//Singleton ( when u want both the properties and resources to be shared)
	/*Sheep s1 = new Sheep();
	s1.name = "Sheep1";
	Sheep s2 = s1;
	s2.name = "Sheep2";
	
	System.out.println("Sheep 1....:"+s1.name);
	System.out.println("Sheep 2....:"+s2.name);
	*/
	
	Sheep s1 = new Sheep();
	s1.name = "Sheep1";
	Sheep s2 = s1.getSheepClone();
	s2.name = "Sheep2";
	
	System.out.println("Sheep 1....:"+s1.name);
	System.out.println("Sheep 2....:"+s2.name);
}
}

class Sheep implements Cloneable{
	String name;
	public Sheep() {
		System.out.println("object is created.....");
	}
	
	public Sheep getSheepClone() throws Throwable
	{
		return (Sheep)super.clone();
	}
}