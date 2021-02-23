package FanDemo;



public class FanDemo {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//	SaitanFan s = new SaitanFan();
//	for(int i=0;i<10;i++)
//		s.pull();
	GoodFan fan = Container.get(args[0]);
//	State state = new Onstate();
//	fan.state = state;
	for(int i=0;i<4;i++)
	 fan.pull();
}
}

class Container
{
	public static GoodFan get(String p) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		GoodFan fan = new GoodFan();
		State state = (State)Class.forName(p).newInstance();
		fan.state = state;
		return fan;
		
	}
}

//class SaitanFan{
//	int s = 0;
//	public void pull()
//	{
//		if(s==0)
//			{System.out.println("Switch on state");
//			s=1;}
//		else if(s==1)
//		{
//			System.out.println("medium speed state");
//			s=2;
//		}
//		else if(s==2)
//		{
//			System.out.println("High speed state");
//			s=3;
//		}
//		else if(s==3)
//		{
//			System.out.println("Switch off state");
//			s=0;
//		}
//	}
//}


class GoodFan
{
	State state;
	public void pull()
	{
		state.changeState(this);
		
	}
}

abstract class State
{
	public abstract void changeState(GoodFan fan);
	
}

class OnState extends State
{
	@Override
	public void changeState(GoodFan fan) {
		System.out.println("Medium speed state.....");
		fan.state = new MediumSpeedState();
	}
}

class MediumSpeedState extends State
{@Override
public void changeState(GoodFan fan) {
	
	System.out.println("High speed state.....");
	fan.state = new HighSpeedState();
}
	
}

class HighSpeedState extends State
{
	@Override
	public void changeState(GoodFan fan) {
		
		System.out.println("Off state.....");
		fan.state = new OffState();
	}
	
}

class OffState extends State
{
	@Override
	public void changeState(GoodFan fan) {
		System.out.println("On state.....");
		fan.state = new OnState();
	}
	
}
