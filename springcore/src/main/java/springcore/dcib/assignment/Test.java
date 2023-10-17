package springcore.dcib.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {
	public static 
	ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
			"classpath:/springcore"
			+ "/dcib/assignment/config.xml");
		
		University university = (University) ctx.getBean("university");
		System.out.println(university);
		
		ctx.close();
	}

}
