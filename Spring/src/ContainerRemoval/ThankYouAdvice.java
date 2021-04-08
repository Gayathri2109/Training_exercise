package ContainerRemoval;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ThankYouAdvice implements AfterReturningAdvice{
@Override
public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
	System.out.println("Packing to be done for....."+arg0);
	System.out.println("Thank you for shopping...come again....");
	
}
}
