package ContainerRemoval;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FactoryClient {
	public static void main(String[] args) {
		try {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		//new FileSystemXmlApplicationContext();
		
		/*GokulShoeShop seller=ctx.getBean("shop",GokulShoeShop.class);
		
		Customer customer=new ShoeCustomer("ramu");
//		
//		
		Shoe shoe=seller.sellShoe(customer);
		
		System.out.println(shoe);
		
		System.out.println(seller.getFactory().getKey());
		System.out.println(seller.getKey());
		
		*/
		
		ShoeSeller seller=ctx.getBean("advisedshop",ShoeSeller.class);
		
		Customer customer=new ShoeCustomer("ramu");
//		
//		
		Shoe shoe=seller.sellShoe(customer);
		//seller.test();
		//seller.sellShoe(customer);
		
		Export ex = (Export)seller;
		ex.doExport();
		//System.out.println(shoe);
		
	
//		
////		ctx.getBean("shop",ShoeSeller.class);
////		ctx.getBean("shop",ShoeSeller.class);
//		
//		GokulShoeShop seller2=seller.getClone();
//		
//		System.out.println(seller2.getName());
//		System.out.println(seller2.getMylist());
		//ctx.close();
	}catch (Exception e) {
		System.out.println(e);
	}
}}
