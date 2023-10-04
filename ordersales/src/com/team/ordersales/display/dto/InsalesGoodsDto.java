package com.team.ordersales.display.dto;

public class InsalesGoodsDto {
	private String goodsCode;
	private String goodsName;
	private int price;
	
	public InsalesGoodsDto() {}

	public InsalesGoodsDto(String goodsCode, String goodsName, int price) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
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
	
	

}
