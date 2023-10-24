package com.springmybatis.conditions;

public class UpdateCondition {
	private String id;
	private String address;
	public UpdateCondition() {
	}
	public UpdateCondition(String id, String address) {
		this.id = id;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
