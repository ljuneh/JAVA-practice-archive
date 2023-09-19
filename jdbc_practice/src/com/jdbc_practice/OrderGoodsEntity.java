package com.jdbc_practice;

//ENTITY
public class OrderGoodsEntity {
	private int SEQ;
	private String GOODSCODE;
	private String GOODSNAME;
	private String RAWMATERIALCODE; 
	private int RAWMATERIALQUANTITY;
	private String INSALES;
	
	public OrderGoodsEntity() {}
	
	public OrderGoodsEntity(int SEQ, String GOODSCODE, String GOODSNAME, 
			String RAWMATERIALCODE, int RAWMATERIALQUANTITY, String INSALES) {
		this.SEQ = SEQ;
		this.GOODSCODE = GOODSCODE;
		this.GOODSNAME =GOODSNAME;
		this.RAWMATERIALCODE = RAWMATERIALCODE;
		this.RAWMATERIALQUANTITY = RAWMATERIALQUANTITY;
		this.INSALES = INSALES;
	}

	public int getSEQ() {
		return SEQ;
	}

	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	public String getGOODSCODE() {
		return GOODSCODE;
	}

	public void setGOODSCODE(String gOODSCODE) {
		GOODSCODE = gOODSCODE;
	}

	public String getGOODSNAME() {
		return GOODSNAME;
	}

	public void setGOODSNAME(String gOODSNAME) {
		GOODSNAME = gOODSNAME;
	}

	public String getRAWMATERIALCODE() {
		return RAWMATERIALCODE;
	}

	public void setRAWMATERIALCODE(String rAWMATERIALCODE) {
		RAWMATERIALCODE = rAWMATERIALCODE;
	}

	public int getRAWMATERIALQUANTITY() {
		return RAWMATERIALQUANTITY;
	}

	public void setRAWMATERIALQUANTITY(int rAWMATERIALQUANTITY) {
		RAWMATERIALQUANTITY = rAWMATERIALQUANTITY;
	}

	public String getINSALES() {
		return INSALES;
	}

	public void setINSALES(String iNSALES) {
		INSALES = iNSALES;
	}
	
	@Override
	public String toString() {
		return String.format("상품코드: %-9s │ 상품이름: %-6s │ 판매여부: %s", GOODSCODE, GOODSNAME, INSALES);
	}
	
}
