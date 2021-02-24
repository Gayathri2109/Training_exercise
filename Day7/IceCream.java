package Day7;

public class IceCream {
public static void main(String[] args) {
	Icecream1 icecream = new DryFruits(new StrawBerry(new TrutyFruity(new Vannila())));
	System.out.println("Cost of the ice cream: "+icecream.cost());
}
}

abstract class Icecream1
{
	public abstract int cost();
}

abstract class cream extends Icecream1{}
abstract class IceCreamIngredients extends Icecream1{}

class Vannila extends cream{
	Icecream1 ic;
	public Vannila() {
		// TODO Auto-generated constructor stub
	}
	public Vannila(Icecream1 ic) {
		this.ic = ic;
	}
	@Override
	public int cost() {
		if(this.ic==null)
			return 10;
		else
			return 10+this.ic.cost();
	}
	
}

class StrawBerry extends cream{
	Icecream1 ic;
	public StrawBerry() {
		// TODO Auto-generated constructor stub
	}
	public StrawBerry(Icecream1 ic) {
		this.ic = ic;
	}
	@Override
	public int cost() {
		if(this.ic == null)
			return 20;
		else
			return 20+this.ic.cost();
	}
}

class DryFruits extends IceCreamIngredients{
	Icecream1 ic;
	public DryFruits(Icecream1 ic) {
		this.ic = ic;
	}
	@Override
	public int cost() {
		return 5+this.ic.cost();
	}
}

class TrutyFruity extends IceCreamIngredients{
	Icecream1 ic;
	public TrutyFruity(Icecream1 ic) {
		this.ic = ic;
	}
	@Override
	public int cost() {
		return 10+this.ic.cost();
	}
}