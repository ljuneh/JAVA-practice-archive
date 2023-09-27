package com.team.ordersales.login.dto;

public class RetrieveMemberDto {
	private String id;
	private String password;
	private String role;
	private String addr;
	public RetrieveMemberDto() {
	}
	public RetrieveMemberDto(String id, String password, String role, String addr) {
		this.id = id;
		this.password = password;
		this.role = role;
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
