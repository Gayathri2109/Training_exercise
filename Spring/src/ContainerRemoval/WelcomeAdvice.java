package ContainerRemoval;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


public class WelcomeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] arg, Object bean) throws Throwable {
		Customer cust = (Customer)arg[0];
		String name = cust.getName();
		System.out.println("Welcome to my shop...."+name);

	}
	

}
