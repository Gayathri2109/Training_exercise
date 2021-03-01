package Day10;

public class DecoratorCloningTry1 {
public static void main(String[] args) throws Exception {
	
	PotatoeFries p = PotatoeFries.getObject();
	ChickenPops c = ChickenPops.getObject();
	PotatoeFries p1 = p.getCloneObject();
	Snacks s = p.getCloneObject(p1.getCloneObject(c.getcloneObject(p.getCloneObject(c.getcloneObject()))));
	System.out.println("Total Cost of the snack is..."+s.getCost());
}
}

abstract class Snacks{
	public abstract int getCost();
}
abstract class VegSnacks extends Snacks{
	
}
abstract class NonvegSnacks extends Snacks{
	
}

class PotatoeFries extends VegSnacks implements Cloneable{
	
	Snacks s;
	public PotatoeFries() {
		// TODO Auto-generated constructor stub
	}
	
	public PotatoeFries(Snacks s) {
		this.s = s;
	}
	
	public static PotatoeFries getObject()
	{
		return new PotatoeFries();
	}
	public static PotatoeFries getObject(Snacks s)
	{
		return new PotatoeFries(s);
	}
	
	public PotatoeFries getCloneObject() throws Exception
	{
		return (PotatoeFries)super.clone();
	}
	
	public PotatoeFries getCloneObject(Snacks s) throws Exception
	{
		this.s = s;
		return (PotatoeFries)super.clone();
	}
	
	
	@Override
	public int getCost() {
		if(this.s == null)
			return 30;
		else
			return 30+s.getCost();
	}
}

class ChickenPops extends NonvegSnacks implements Cloneable{
	Snacks s;
	
	public ChickenPops() {
	// TODO Auto-generated constructor stub
	
	}	
	public ChickenPops(Snacks s) {
		this.s = s;
	}
	
	public static ChickenPops getObject()
	{
		return new ChickenPops();
	}
	
	public static ChickenPops getObject(Snacks s)
	{
		return new ChickenPops(s);
	}
	public ChickenPops getcloneObject() throws Exception
	{
		return (ChickenPops)super.clone();
	}
	public ChickenPops getcloneObject(Snacks s) throws Exception
	{
		this.s = s;
		return (ChickenPops)super.clone();
	}
	

	 @Override
	public int getCost() {
		if(this.s == null)
			return 60;
		else
			return 60+s.getCost();
	}
}
