package Day10;

public class SimpleCloning {
public static void main(String[] args) throws Exception {
	//Multiton - already we do have an structure...why do we need another object...
	/*Animal obj1 = new Animal();
	obj1.name = "Doggy";
	obj1.getAnimalName();
	Animal obj2 = new Animal();
	obj2.name = "Pussie Cat";
	obj2.getAnimalName();*/
	
	/*Animal obj1 = new Animal();
	obj1.name = "Doggy";
	Animal obj2 = obj1; //Singleton - when u want both the properties and the resources to be shared.... 
	obj2.name = "Pussie Cat";
	obj1.getAnimalName();
	obj2.getAnimalName();*/
	
	Animal obj1 = Animal.getObject();
	obj1.name = "Doggy";
	Animal obj2 = obj1.getCloneObject();
	obj2.name = "Pussie Cat";
	obj1.getAnimalName();
	obj2.getAnimalName();
}
}

class Animal implements Cloneable{
	String name;
	private Animal() {
		System.out.println("Object created");
	}
	public void getAnimalName()
	{
		System.out.println("The animal is.... "+name);
	}
	public static Animal getObject()
	{
		return new Animal();
	}
	
	public Animal getCloneObject() throws Exception
	{
		return (Animal)super.clone();
	}
}