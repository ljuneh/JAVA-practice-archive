package springcore.innerbean;

public class Employee {
	
	private int id;
	private Adress adress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+getId()+", adress: "+getAdress();
	}

}
