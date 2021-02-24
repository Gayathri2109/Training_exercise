package Day7;

public class Incompatability {
public static void main(String[] args) {
	IndianSocket is = new Shakthisocket();
	AmericanPlug ap = new LenovaPlug();
	
	IndianAdapter ia = new IndianAdapter(ap);
	ia.roundPin();
	
}
}
class IndianAdapter extends IndianPlug
{
	AmericanPlug ap;
	public IndianAdapter(AmericanPlug ap) {
		this.ap = ap;
	}
	
	@Override
	public void roundPin() {
		ap.slabPin();
		
	}
}

abstract class IndianSocket{
	public abstract void rounPinHole(IndianPlug ip);
}

abstract class AmericanSocket{
	public abstract void slabPinHole(AmericanPlug ap);
}

abstract class IndianPlug{
	public abstract void roundPin();
}

abstract class AmericanPlug{
	public abstract void slabPin();
}

class Shakthisocket extends IndianSocket{
	
	@Override
	public void rounPinHole(IndianPlug ip) {
		ip.roundPin();
	}
}

class LenovaPlug extends AmericanPlug{
	@Override
	public void slabPin() {
		System.out.println("Slab pin Working....");
	}
}
