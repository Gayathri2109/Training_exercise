package PaintDemo;

public class PaintDemo {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	PaintBrush brush = Container.getContainer(args[0]);
	//Paint paint = new RedPaint();
	//brush.paint = paint;
	brush.doPaint();
}
}

class Container
{
	public static PaintBrush getContainer(String P) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		PaintBrush brush = new PaintBrush();
		Paint paint = (Paint)Class.forName(P).newInstance();
		//Dependency Injection
		brush.paint = paint;
		return brush;
	}
}

//Normal if else-if condition
//class Paint
//{
//	public void getPaint(int i)
//	{
//		if(i==1)
//			System.out.println("Red Paint");
//		else if (i==2)
//			System.out.println("Blue Paint");
//		else
//			System.out.println("Black Paint");
//	}
//}

class PaintBrush
{
	Paint paint;
	public void doPaint()
	{
		System.out.println(paint);
	}
}

abstract class Paint{
}

class RedPaint extends Paint{
	
}

class BluePaint extends Paint {
	
}

