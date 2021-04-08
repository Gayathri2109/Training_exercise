package ContainerRemoval;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Daotest {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		DBDao dao = (DBDao)ctx.getBean("dao");
		dao.firsttest();
	}
}
