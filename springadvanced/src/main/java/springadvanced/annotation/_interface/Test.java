package springadvanced.annotation._interface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static 
	ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:/springadvanced/annotation/_interface/config.xml");
		
		OrderService service = (OrderService) ctx.getBean("orderServiceImpl");
		service.placeOrder();
		
		ctx.close();
	}

}
