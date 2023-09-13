package com.project2nd.sales;

public class SalesInfo {
	private String sGoodsCode;
	private int iSalesQty;

	public SalesInfo() {}

	public SalesInfo(String sGoodsCode, int iSalesQty) {
		this.sGoodsCode = sGoodsCode;
		this.iSalesQty = iSalesQty;
	}
	
	public String getsGoodsCode() {
		return sGoodsCode;
	}

	public void setsGoodsCode(String sGoodsCode) {
		this.sGoodsCode = sGoodsCode;
	}

	public int getiSalesQty() {
		return iSalesQty;
	}

	public void setiSalesQty(int iSalesQty) {
		this.iSalesQty = iSalesQty;
	}



}
