package springcore.constructorinjection;


public class Employee {
	
	private int id;
	private Address address;
	
	public Employee() {};
	
	
	
	public Employee(int id, Address address) {
		this.id = id;
		this.address = address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+getId()+", adress: "+getAddress();
	}

}
