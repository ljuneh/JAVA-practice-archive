package springadvanced.properties;

public class MyDao {
	private String connection;

	public MyDao(String connection) {
		this.connection = connection;
	}
	
	public String getConnection() {
		return connection;
	}

	@Override
	public String toString() {
		return "connection:" + getConnection();
	}
}
