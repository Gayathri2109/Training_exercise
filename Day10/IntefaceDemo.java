package Day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IntefaceDemo {
public static void main(String[] args) {
	SatnleyAllopathy stanley = new SatnleyAllopathy();
	Human gayu = new Human();
	gayu.doCry();
	
	Object obj = Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[] {Doctor.class},new IntefaceDemo.MyInvocationHandler(stanley));
	Doctor doctorGayu = (Doctor)obj;
	doctorGayu.doCure();
}

	static class MyInvocationHandler implements InvocationHandler{
		Object obj;
		public MyInvocationHandler(Object obj)
		{
			this.obj = obj;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("Method...."+method.getName());
			System.out.println("args..."+args);
			Object o =  method.invoke(obj, args);
			return o;
		}
	}
}

class Human{
	public void doCry()
	{
		System.out.println("Human Crying...");
	}
}

interface Doctor{
	public void doCure();
}

class SatnleyAllopathy implements Doctor{
	@Override
	public void doCure() {
		System.out.println("Allopathy....");
		
	}
}
class AnnaUnani implements Doctor{
	@Override
	public void doCure() {
		System.out.println("Unani....");
		
	}
}

interface Pilot{
	public void doFly();
}

interface Steward{
	public void doServe();
}

class JetAcademy implements Pilot,Steward{
	@Override
	public void doFly() {
		System.out.println("Flying aeroplane is implemented here...");
		
	}@Override
	public void doServe() {
		System.out.println("serving passengers....");
		
	}
}