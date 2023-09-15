package com.jdbc_practice;

public class SalesInfo {
	
	private String goodsCode;
	private int orderQuantity;
	private String salesDate;
	
	public SalesInfo() {}
	
	public SalesInfo(String goodsCode, int orderQuantity, String salesDate) {
		this.goodsCode = goodsCode;
		this.orderQuantity = orderQuantity;
		this.salesDate = salesDate;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
	
	@Override
	public String toString() {
		return String.format("상품코드: %s, 상품수량: %s, 결제시간: %s", goodsCode, orderQuantity, salesDate);
	}

}
