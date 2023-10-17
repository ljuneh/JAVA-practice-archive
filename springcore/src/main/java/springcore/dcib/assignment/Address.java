package springcore.dcib.assignment;

import org.springframework.beans.factory.annotation.Required;

public class Address {
	private String street;
	private String city;
	
	public String getStreet() {
		return street;
	}
	
	@Required
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(street: %s, city: %s)", getStreet(), getCity());
	}

}
