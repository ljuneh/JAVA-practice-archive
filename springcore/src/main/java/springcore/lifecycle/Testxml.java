package springcore.lifecycle;

//import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testxml {
//	private static AbstractApplicationContext context;
	public static ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springcore/lifecycle/xmlconfig.xml");
		
		Patientxml patient = (Patientxml) ctx.getBean("patientxml");
		System.out.println(patient);
//		1.8 이상 버전에서
//		context.registerShutdownHook();
		ctx.close();
	}
}
