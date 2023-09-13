package com.project2nd.sales;

public class Material {
	private int id;// Entity 클래스 <-> 테이블
	private String sMaterialCode;
	private String sMaterialName;
	private String iMaterialType; // 1: 커피, 2: 쥬스
	
	public Material() {}

	public Material(int id, String sMaterialCode, String sMaterialName, String iMaterialType) {
		this.id = id;
		this.sMaterialCode = sMaterialCode;
		this.sMaterialName = sMaterialName;
		this.iMaterialType = iMaterialType;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsMaterialCode() {
		return sMaterialCode;
	}

	public void setsMaterialCode(String sMaterialCode) {
		this.sMaterialCode = sMaterialCode;
	}

	public String getsMaterialName() {
		return sMaterialName;
	}

	public void setsMaterialName(String sMaterialName) {
		this.sMaterialName = sMaterialName;
	}

	public String getiMaterialType() {
		return iMaterialType;
	}

	public void setiMaterialType(String iMaterialType) {
		this.iMaterialType = iMaterialType;
	}
}
