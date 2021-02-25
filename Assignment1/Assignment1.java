package Assignment1;

public class Assignment1 {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	ShoeShop ss = Container.getShoeShop(args[0]);
	Customer customer = new ShoeCustomer("Ram");
	Shoe shoe = ss.sellShoe(customer);
	System.out.println(shoe);
}
}

class Container{
	public static ShoeShop getShoeShop(String p) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ShoeShop ss = (ShoeShop)Class.forName(p).newInstance();
		return ss;
	}

}

interface ShoeManuFacturer{
	public void makeShoe();
}

interface ShoeSeller{
	public void sellShoe();
}


abstract class Shoe{
	Customer cust;
	
	
	public Shoe(Customer cust) {
		this.cust = cust;
		
	}	
	
}

abstract class ShoeFactory implements ShoeManuFacturer{
	public abstract void makeShoe();
}

abstract class ShoeShop implements ShoeSeller{
	public abstract Shoe sellShoe(Customer customer);
}

abstract class Customer{
	
}

class ShoeCustomer extends Customer{

	;
	public ShoeCustomer(String s) {
		System.out.println(s + " wants to buy a shoe...");
	}
	
}

class GokulShoeShop extends ShoeShop{
	Shoe shoe;
	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("Shoe selled by GokulShoeshop....");
		return  new LeatherShoe(customer);
	}
	@Override
	public void sellShoe() {
		
	}
}

class LeatherShoe extends Shoe{

	public LeatherShoe(Customer cust) {
		super(cust);
	}
}


class BalaShoeFactory extends ShoeFactory{
	@Override
	public void makeShoe() {
		System.out.println("Shoe made by BalaShoeFactory....");
		
	}
}

class LathaShoeFactory extends ShoeFactory{
@Override
	public void makeShoe() {
		System.out.println("Shoe made by LathaShoeFactory....");
		
	}	
}

