package com.project2nd.sales;

public class OrderInfo {
	private String sGoodsCode;
	private int iOrderQty;
	private boolean bOrderConfirmed;

	public OrderInfo() {}

	public OrderInfo(String sGoodsCode, int iOrderQty, boolean bOrderConfirmed) {
		this.sGoodsCode = sGoodsCode;
		this.iOrderQty = iOrderQty;
		this.bOrderConfirmed = bOrderConfirmed;
	}

	public String getsGoodsCode() {
		return sGoodsCode;
	}

	public void setsGoodsCode(String sGoodsCode) {
		this.sGoodsCode = sGoodsCode;
	}

	public int getiOrderQty() {
		return iOrderQty;
	}

	public void setiOrderQty(int iOrderQty) {
		this.iOrderQty = iOrderQty;
	}

	public boolean isbOrderConfirmed() {
		return bOrderConfirmed;
	}

	public void setbOrderConfirmed(boolean bOrderConfirmed) {
		this.bOrderConfirmed = bOrderConfirmed;
	}

}
