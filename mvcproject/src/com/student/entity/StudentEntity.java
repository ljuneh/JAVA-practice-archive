package com.student.entity;

public class StudentEntity {
	private String sFirstName;
	private String sLastName;
	private String sAdress;
	
	public StudentEntity() {}
	
	public StudentEntity(String sFirstName, String sLastName, String sAdress) {
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.sAdress = sAdress;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getsAdress() {
		return sAdress;
	}

	public void setsAdress(String sAdress) {
		this.sAdress = sAdress;
	}

}
