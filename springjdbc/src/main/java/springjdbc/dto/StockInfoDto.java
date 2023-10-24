package springjdbc.dto;

public class StockInfoDto {
	private String rawMaterialName;
	
	private int rawMaterialQuantity;
	
	public StockInfoDto() {}
	
	public StockInfoDto(String rawMaterialName, int rawMaterialQuantity) {
		this.rawMaterialName = rawMaterialName;
		this.rawMaterialQuantity = rawMaterialQuantity;
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
		// TODO Auto-generated method stub
		return String.format("원자재 이름: %s, 원자재 수량: %d", getRawMaterialName(), getRawMaterialQuantity());
	}

}
