package Day13;

public class Generics {
public static void main(String[] args) {
	Paintbrush<Water> p = new Paintbrush<>();
	p.obj = new Water();
	System.out.println(p.getObj());
	
	Paintbrush<Paint> p1 = new Paintbrush<>();
	p1.obj = new RedPaint();
	Paint paint = p1.getObj();
	System.out.println(p1.getObj());
}
}


class Paintbrush<T>{
	T obj;
	public T getObj() {
		return obj;
	}
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	
}

class Water{
	
}