package springcore.lifecycle;

public class Patientxml {
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
	
	public void init() {
		System.out.println("init()");
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}
