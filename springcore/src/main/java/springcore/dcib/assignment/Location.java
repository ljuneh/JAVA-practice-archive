package springcore.dcib.assignment;

import org.springframework.beans.factory.annotation.Required;

public class Location {
	private int x;
	private int y;
	private Address address;
	
	public int getX() {
		return x;
	}
	
	@Required
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
		return String.format("(x: %d, y: %d, address: %s)", getX(), getY(), getAddress());
	}

}
