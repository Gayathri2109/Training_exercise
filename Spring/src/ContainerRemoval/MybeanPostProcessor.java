package ContainerRemoval;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mysql.cj.result.Field;

public class MybeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		System.out.println("After init method....."+bean+":"+name);
		try {
		java.lang.reflect.Field field = bean.getClass().getSuperclass().getDeclaredField("key");
		if(field!=null) {
		field.setAccessible(true);
		String val = (String)field.get(bean);
		if(val==null) {
			field.set(bean,"secret Key....set by post processor");
		}}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		System.out.println("Before init method..."+bean+":"+name);
		return bean;
	}

}
