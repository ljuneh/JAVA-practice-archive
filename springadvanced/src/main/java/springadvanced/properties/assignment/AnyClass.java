package springadvanced.properties.assignment;

public class AnyClass {
	private String userName;
	
	public AnyClass() {}
	public AnyClass(String userName) {
		this.userName=userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getUserName();
	}
}
