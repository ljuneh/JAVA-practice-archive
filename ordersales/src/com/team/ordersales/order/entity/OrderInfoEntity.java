package com.team.ordersales.order.entity;

import java.util.Date;

public class OrderInfoEntity {
	private int seq;
	private String goodsCode;
	private int orderQuantity;
	private String orderConfirmed;
	private Date orderDate;
	private String id;
	
	public OrderInfoEntity() {}
	
	public OrderInfoEntity(int seq, String goodsCode, int orderQuantity, String orderConfirmed, String id) {
		this.seq = seq;
		this.goodsCode = goodsCode;
		this.orderQuantity = orderQuantity;
		this.orderConfirmed = orderConfirmed;
		this.id = id;
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

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
