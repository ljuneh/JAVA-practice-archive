package springadvanced.annotation.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("comp")
public class Company {
	@Value("홍길동 주식회사")
	private String name;
	@Autowired
	private Location location;
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
		return String.format("name: %s, location: (%s)", getName(), getLocation());
	}
}
