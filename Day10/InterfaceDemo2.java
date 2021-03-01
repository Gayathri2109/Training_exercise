package Day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemo2 {
	
public static void main(String[] args) {
	Object human = new Human2();
	//human.doCry();
	System.out.println("I want to become a pilot.....");
	Scanner scan = new Scanner(System.in);
	scan.next();
	
	stanley2 stan = new stanley2();
	jacademy jet = new jacademy();
	human = Proxy.newProxyInstance(Human2.class.getClassLoader(), new Class[] {Pilot2.class}, new MyInvocationHandler(jet));
	

	
	Pilot2 pilot = (Pilot2)human;
	pilot.doFly();
	
	
	System.out.println("I want to become a Doctor.....");
	scan.next();
	human = Proxy.newProxyInstance(Human2.class.getClassLoader(), new Class[] {doctor2.class}, new MyInvocationHandler(stan));
	
	doctor2 doc = (doctor2)human;
	doc.doCure();
}
}

class MyInvocationHandler implements InvocationHandler {

	Object obj;
	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}
	
	@Override
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke method invoked....");
		Object oo = method.invoke(obj, args);
		return oo;
	}
	
}

class Human2{

}

interface doctor2{
	public void doCure();
}

class stanley2 implements doctor2{
	@Override
	public void doCure() {
		System.out.println("I became a alopathy doctor.....");
		
	}
	
}

interface Pilot2{
	public void doFly();
}

class jacademy implements Pilot2 {
	@Override
	public void doFly() {
		System.out.println("You can fly the airplane now....");
		
	}
	
}

