package BadChildDogDemo;

import java.util.Scanner;

public class BadChildDogDemo {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//	NaughtyChild child = new NaughtyChild();
//	BullDog dog = new BullDog();
//	Scanner s = new Scanner(System.in);
//	String item;
//	System.out.println("Enter an item....");
//	item = s.next();
//	child.playwithdog(dog, item);
	
	NaughtyChild child = new NaughtyChild();
	BullDog dog = Container.get(args[0]);
	child.playwith(dog);
	
}
}

class Container
{
	public static BullDog get(String p) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	BullDog dog = new BullDog();
	Play play = (Play)Class.forName(p).newInstance();
	dog.play = play;
	return dog;
	}
}
//class BullDog
//{
//	public void play(String item)
//	{
//		if(item.equals("Stick"))
//			System.out.println("You beat I bite");
//		else if(item.equals("Stone"))
//			System.out.println("You hit I bark");
//	}
//}

class BullDog
{
	Play play;
	public void get()
	{
		play.playwithdog();
	}
	
}

abstract class Play
{
	public abstract void playwithdog(); 
	
}

class Stick extends Play{
	@Override
	public void playwithdog() {
		// TODO Auto-generated method stub
		System.out.println("You beat I bite");
	}
}

class Stone extends Play
{
	@Override
	public void playwithdog() {
		// TODO Auto-generated method stub
		System.out.println("You hit I bark");
	}
}


class NaughtyChild
{
	public void playwith(BullDog dog)
	{
		dog.get();
	}
}
