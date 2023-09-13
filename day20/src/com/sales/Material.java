package com.sales;

public class Material {				// Entity 클래스 <-> 테이블
	private String sMaterialCode;
	private String sMaterialName;
	private int iMaterialType; // 1: 커피, 2: 쥬스

	public Material() {}

	public Material(String sMaterialCode, String sMaterialName, int iMaterialType) {
		this.sMaterialCode = sMaterialCode;
		this.sMaterialName = sMaterialName;
		this.iMaterialType = iMaterialType;
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

	public int getiMaterialType() {
		return iMaterialType;
	}

	public void setiMaterialType(int iMaterialType) {
		this.iMaterialType = iMaterialType;
	}
}
