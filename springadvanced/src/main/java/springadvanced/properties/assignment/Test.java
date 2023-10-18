package springadvanced.properties.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {	
	
	public static 
		ClassPathXmlApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
			"classpath:/springadvanced/properties/assignment/propsconfig.xml");
		
		AnyClass anyClass = (AnyClass) ctx.getBean("anyclass");
		System.out.println(anyClass);
		
		ctx.close();
	}
}
