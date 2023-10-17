package springcore.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInterface {
	public static ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springcore/lifecycle/interfaceconfig.xml");
		PatientInterface patientInterface = (PatientInterface) ctx.getBean("patientinterface");
		System.out.println(patientInterface);
		
		ctx.close();
	}

}
