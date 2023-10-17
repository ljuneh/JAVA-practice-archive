package springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PatientAnnotation {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String msg = getId() + ":" + getName();
		return msg;
	}
	
	@PostConstruct
	public void hi() {
		System.out.println("hi()");
	}
	
	@PreDestroy
	public void bye() {
		System.out.println("bye()");
	}

}
