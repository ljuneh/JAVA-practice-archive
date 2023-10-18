package springadvanced.autowiring.assignment;

public class Reservation {
	private int id;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("reservation : (id: %d, time: %s)", getId(), getTime());
	}

}
