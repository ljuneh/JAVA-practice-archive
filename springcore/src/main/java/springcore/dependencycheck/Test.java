package springcore.dependencycheck;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {	
	
	public static 
		ClassPathXmlApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
			"classpath:/springcore"
			+ "/dependencycheck/dependencycheckconfig.xml");
		Predescription predescription = 
				(Predescription)ctx.getBean("prescription");
		System.out.println(predescription);
		ctx.close();
	}
}
