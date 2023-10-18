package springadvanced.autowiring.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static 
	ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:/springadvanced/autowiring/assignment/config.xml");
		Customer customer = (Customer) ctx.getBean("customer");
		
		System.out.println(customer);
		
		ctx.close();
	}

}
