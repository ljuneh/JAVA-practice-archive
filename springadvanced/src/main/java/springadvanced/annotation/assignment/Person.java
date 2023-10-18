package springadvanced.annotation.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Person {
	@Value("홍길동")
	private String name;
	@Autowired
	private Address address;
	@Autowired
	@Qualifier("comp")
	private Company company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("name: %s, address: (%s), company: (%s)", getName(), getAddress(), getCompany());
	}
}
