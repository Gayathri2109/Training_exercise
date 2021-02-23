package Pizza;

public class Pizza {
public static void main(String[] args) {
	Dominos domi = new CoimbiDominosPizza();
	domi.makePizza();
}
}


abstract class Dominos
{
	final public void SelectAtta()
	{
		System.out.println("Atta Selected.......");
	}
	final public void getIngredients()
	{
		System.out.println("Ingredients Selected.......");
	}
	final public void PackingDabba()
	{
		System.out.println("Pizza Packed......");
	}
	final public void ToCook()
	{
		SelectAtta();
		getIngredients();
	}
	public abstract void delivery();
	public abstract void makePizza();
}

class CoimbiDominosPizza extends Dominos
{
	@Override
	public void makePizza() {
		ToCook();
		System.out.println("Cooking........");
		PackingDabba();
		delivery();
	}
	@Override
	public void delivery() {
		System.out.println("Pizza Delivered....");
		
	}
}