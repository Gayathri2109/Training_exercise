package ContainerRemoval;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ValidationAdvice implements MethodInterceptor{
	List<Customer> list = new ArrayList<Customer>();
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
	
		
		Customer cut = (Customer)arg0.getArguments()[0];
		if(list.contains(cut)) {
			throw new OneShoePerCustomerException("Only one shoe per customer.....");
		}else {
			list.add(cut);
			Object obj = arg0.proceed();
			return obj;
		}
	}
	
}
