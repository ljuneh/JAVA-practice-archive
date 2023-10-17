package springcore.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
	public static ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springcore/lifecycle/annotationconfig.xml");
		PatientAnnotation patientAnnotation = (PatientAnnotation) ctx.getBean("patientannotation");
		
		System.out.println(patientAnnotation);
		ctx.close();
	}

}
