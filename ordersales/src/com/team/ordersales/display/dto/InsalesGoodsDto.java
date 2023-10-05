package com.team.ordersales.display.dto;

public class InsalesGoodsDto {
	private String goodsCode;
	private String goodsName;
	private int price;
	private int rawmaterialquantity;
	private int currentrawquantity;
	
	public InsalesGoodsDto() {}

	public InsalesGoodsDto(String goodsCode, String goodsName, int price, int rawmaterialquantity, int currentrawquantity) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
		this.rawmaterialquantity = rawmaterialquantity;
		this.currentrawquantity = currentrawquantity;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRawmaterialquantity() {
		return rawmaterialquantity;
	}

	public void setRawmaterialquantity(int rawmaterialquantity) {
		this.rawmaterialquantity = rawmaterialquantity;
	}

	public int getCurrentrawquantity() {
		return currentrawquantity;
	}

	public void setCurrentrawquantity(int currentrawquantity) {
		this.currentrawquantity = currentrawquantity;
	}
	
	

}
