package jdbc;

public class InsalesGoodsEntity {
	private int seq;
	private String goodsCode;
	private String goodsName;
	private String rawMaterialCode;
	private int rawMaterialQuantity;
	
	public InsalesGoodsEntity() {}
	
	public InsalesGoodsEntity(int seq, String goodsCode, String goodsName, 
			String rawMaterialCode, int rawMaterialQuantity) {
		this.seq = seq;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.rawMaterialCode = rawMaterialCode;
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

	public String getRawMaterialCode() {
		return rawMaterialCode;
	}

	public void setRawMaterialCode(String rawMaterialCode) {
		this.rawMaterialCode = rawMaterialCode;
	}

	public int getRawMaterialQuantity() {
		return rawMaterialQuantity;
	}

	public void setRawMaterialQuantity(int rawMaterialQuantity) {
		this.rawMaterialQuantity = rawMaterialQuantity;
	}
	
	@Override
	public String toString() {
		return String.format("seq: %d, 상품코드: %s, 상품명: %s, 원자재코드: %s, 원자재수량: %d", 
				seq, goodsCode, goodsName, rawMaterialCode, rawMaterialQuantity);
	}
	
}
