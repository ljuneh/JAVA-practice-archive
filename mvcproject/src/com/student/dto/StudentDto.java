package com.student.dto;

public class StudentDto {
	private String sName;
	private String sRegionType;
	
	public StudentDto() {}
	
	public StudentDto(String sName, String sRegionType) {
		this.sName = sName;
		this.sRegionType = sRegionType;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsRegionType() {
		return sRegionType;
	}

	public void setsRegionType(String sRegionType) {
		this.sRegionType = sRegionType;
	}

}
