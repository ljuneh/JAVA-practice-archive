package springadvanced.annotation.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("inst")
public class Instructor {
	@Value("10")
	private int id;
	@Value("홍길동")
	private String name;
	@Value("#{topics}")
	private List<String> topics;
	@Autowired
	private Address address;
	
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
	
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
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
		return String.format("id: %d, name: %s, topic: %s, address: %s", getId(), getName(), getTopics(), getAddress());
	}
}
