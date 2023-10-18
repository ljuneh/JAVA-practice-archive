package springadvanced.annotation.stereotype;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static 
	ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:/springadvanced/annotation/stereotype/config.xml");
		
		Instructor instructor = (Instructor) ctx.getBean("inst");
		System.out.println(instructor);
		
		ctx.close();
	}

}
