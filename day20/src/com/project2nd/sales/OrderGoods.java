package com.project2nd.sales;
public class OrderGoods {
	// 상품코드: 메인타입+서브타입+일련번호
	private String sGoodsCode;
	private String sGoodsName;
	private String sMaterialCode1;
	private String sMaterialCode2;
	private int iMaterialQty1;
	private int iMaterialQty2;

	public OrderGoods() {
	}

	public OrderGoods(String sGoodsCode, String sGoodsName, 
			String sMaterialCode1, String sMaterialCode2, 
			int iMaterialQty1, int iMaterialQty2, int iOrderQty) {
		this.sGoodsCode 	= sGoodsCode;
		this.sGoodsName 	= sGoodsName;
		this.sMaterialCode1 = sMaterialCode1;
		this.sMaterialCode2 = sMaterialCode2;
		this.iMaterialQty1 	= iMaterialQty1;
		this.iMaterialQty2 	= iMaterialQty2;
	}

	public String getsGoodsCode() {
		return sGoodsCode;
	}

	public void setsGoodsCode(String sGoodsCode) {
		this.sGoodsCode = sGoodsCode;
	}

	public String getsGoodsName() {
		return sGoodsName;
	}

	public void setsGoodsName(String sGoodsName) {
		this.sGoodsName = sGoodsName;
	}

	public String getsMaterialCode1() {
		return sMaterialCode1;
	}

	public void setsMaterialCode1(String sMaterialCode) {
		this.sMaterialCode1 = sMaterialCode;
	}
	
	public String getsMaterialCode2() {
		return sMaterialCode2;
	}

	public void setsMaterialCode2(String sMaterialCode) {
		this.sMaterialCode2 = sMaterialCode;
	}

	public int getiMaterialQty1() {
		return iMaterialQty1;
	}

	public void setiMaterialQty1(int iMaterialQty) {
		this.iMaterialQty1 = iMaterialQty;
	}

	public int getiMaterialQty2() {
		return iMaterialQty2;
	}

	public void setiMaterialQty2(int iMaterialQty) {
		this.iMaterialQty2 = iMaterialQty;
	}
}
