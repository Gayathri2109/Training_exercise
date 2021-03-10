package Day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class AnnotationDemo {

	public static void main(String[] args) throws Exception {
		Paintbrush brush = PaintContainer.getBrush();
		brush.doPaint();
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface In{
	String paintClass();
}
class PaintContainer{
	
	public static Paintbrush getBrush() throws Exception {
		Paintbrush brush = new Paintbrush();
		Field f = brush.getClass().getDeclaredField("paint");
		f.setAccessible(true);
		In in = f.getAnnotation(In.class);
		if(in!=null) {
			String paintClass=in.paintClass();
			brush.paint=(Paint)Class.forName(paintClass).getConstructor().newInstance();
			//brush.paint = new RedPaint();
		}
		else
		{
			
		}
		
		//brush.paint = new RedPaint();
		return brush;
	}
}

class Paintbrush{
	@In(paintClass = "Day17.BluePaint")
	Paint paint;
	public void doPaint()
	{
		System.out.println(paint);
	}
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
}

class BluePaint extends Paint{
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
}
