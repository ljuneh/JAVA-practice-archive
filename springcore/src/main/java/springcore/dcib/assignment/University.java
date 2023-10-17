package springcore.dcib.assignment;

import org.springframework.beans.factory.annotation.Required;

public class University {
	private int id;
	private String name;
	private Location location;
	public int getId() {
		return id;
	}
	
	@Required
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id: %d, name: %s, location: %s", getId(), getName(), getLocation());
	}

}
