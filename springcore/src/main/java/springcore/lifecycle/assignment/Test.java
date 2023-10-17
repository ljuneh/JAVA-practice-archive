package springcore.lifecycle.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springcore/lifecycle/assignment/config.xml");
		
		TicketReservation ticketReservation = (TicketReservation) ctx.getBean("ticketreservation");
		
		System.out.println(ticketReservation);
		
		ctx.close();
	}

}
