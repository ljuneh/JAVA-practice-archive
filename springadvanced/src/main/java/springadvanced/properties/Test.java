package springadvanced.properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {	
	
	public static 
		ClassPathXmlApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
			"classpath:/springadvanced/properties/propsconfig.xml");
		
		MyDao mydao = (MyDao)ctx.getBean("mydao");
		System.out.println(mydao);
		
		ctx.close();
	}
}
