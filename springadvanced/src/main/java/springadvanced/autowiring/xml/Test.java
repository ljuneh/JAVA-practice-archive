package springadvanced.autowiring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static 
	ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:/springadvanced/autowiring/xml/config.xml");
		
		Employee employee = (Employee) ctx.getBean("employee");
		System.out.println(employee);
		
		ctx.close();
	}

}
