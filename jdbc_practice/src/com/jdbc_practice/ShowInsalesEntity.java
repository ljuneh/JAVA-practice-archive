package com.jdbc_practice;

public class ShowInsalesEntity {
	private int seq;
	private String goodsCode;
	private String goodsName;
	private String rawMaterialName;
	private int rawMaterialQuantity;
	
	public ShowInsalesEntity() {}
	
	public ShowInsalesEntity(int seq, String goodsCode, String goodsName, 
			String rawMaterialName, int rawMaterialQuantity) {
		this.seq = seq;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.rawMaterialName = rawMaterialName;
		this.rawMaterialQuantity = rawMaterialQuantity;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getRawMaterialName() {
		return rawMaterialName;
	}

	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}

	public int getRawMaterialQuantity() {
		return rawMaterialQuantity;
	}

	public void setRawMaterialQuantity(int rawMaterialQuantity) {
		this.rawMaterialQuantity = rawMaterialQuantity;
	}
	
	@Override
	public String toString() {
		return String.format("seq: %d, 상품코드: %s, 상품명: %s, 원자재이름: %s, 사용되는 원자재수량: %d", 
				seq, goodsCode, goodsName, rawMaterialName, rawMaterialQuantity);
	}

}
