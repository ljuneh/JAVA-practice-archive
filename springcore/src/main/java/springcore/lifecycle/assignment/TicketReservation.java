package springcore.lifecycle.assignment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TicketReservation {
	private String code;
	private String date;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "code : " + getCode() + ", date : "+getDate();
	}
	
	@PostConstruct
	public void initialize() {
		setCode("00001");
		setDate("2023/10/17");
		System.out.println("init");
	}
	
	@PreDestroy
	public void cleanUp() {
		setCode(null);
		setDate(null);
		System.out.println("cleanup");
	}

}
