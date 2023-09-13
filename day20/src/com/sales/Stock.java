package com.sales;

public class Stock {
	private String sMaterialCode;
	private int iMaterialQty;

	public Stock() {}

	public Stock(String sMaterialCode, int iMaterialQty) {
		this.sMaterialCode = sMaterialCode;
		this.iMaterialQty = iMaterialQty;
	}

	public String getsMaterialCode() {
		return sMaterialCode;
	}

	public void setsMaterialCode(String sMaterialCode) {
		this.sMaterialCode = sMaterialCode;
	}

	public int getiMaterialQty() {
		return iMaterialQty;
	}

	public void setiMaterialQty(int iMaterialQty) {
		this.iMaterialQty = iMaterialQty;
	}

}
