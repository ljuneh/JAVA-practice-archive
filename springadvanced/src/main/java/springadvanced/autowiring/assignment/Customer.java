package springadvanced.autowiring.assignment;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
	private String name;
	@Autowired
	private Reservation reservation;
	
	public Customer() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("name: %s, %s", getName(), getReservation());
	}

}
