package com.jdbc_practice;

import java.sql.Date;

public class SalesInfoEntity {
	
	private String goodsCode;
	private int orderQuantity;
	private Date salesDate;
	
	public SalesInfoEntity() {}
	
	public SalesInfoEntity(String goodsCode, int orderQuantity, Date salesDate) {
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

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
	@Override
	public String toString() {
		return String.format("상품코드: %s, 상품수량: %s, 결제시간: %s", goodsCode, orderQuantity, salesDate);
	}

}
