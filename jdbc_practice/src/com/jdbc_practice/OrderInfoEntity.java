package com.jdbc_practice;

import java.sql.Date;

public class OrderInfoEntity {
	private String goodsCode;
	private int orderQuantity;
	private String orderConfirmed;
	private Date orderDate;
	
	public OrderInfoEntity() {}
	
	public OrderInfoEntity(String goodsCode, int orderQuantity, String orderConfirmed) {
		this.goodsCode = goodsCode;
		this.orderQuantity = orderQuantity;
		this.orderConfirmed = orderConfirmed;
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

	public String getOrderConfirmed() {
		return orderConfirmed;
	}

	public void setOrderConfirmed(String orderConfirmed) {
		this.orderConfirmed = orderConfirmed;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return String.format("상품코드: %s, 상품수량: %d, 결제여부: %s, 결제시간: %s", goodsCode, orderQuantity, orderConfirmed, orderDate);
	}
	

}