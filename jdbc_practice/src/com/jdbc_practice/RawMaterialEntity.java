package com.jdbc_practice;

public class RawMaterialEntity {
	private int id;
	private String rawMaterialCode;
	private String rawMaterialName;
	private String rawMaterialType;
	
	public RawMaterialEntity() {}
	
	public RawMaterialEntity(int id, String rawMaterialCode, String rawMaterialName, String rawMaterialType) {
		this.id = id;
		this.rawMaterialCode = rawMaterialCode;
		this.rawMaterialName = rawMaterialName;
		this.rawMaterialType = rawMaterialType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRawMaterialCode() {
		return rawMaterialCode;
	}

	public void setRawMaterialCode(String rawMaterialCode) {
		this.rawMaterialCode = rawMaterialCode;
	}

	public String getRawMaterialName() {
		return rawMaterialName;
	}

	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}

	public String getRawMaterialType() {
		return rawMaterialType;
	}

	public void setRawMaterialType(String rawMaterialType) {
		this.rawMaterialType = rawMaterialType;
	}
	
	
}
