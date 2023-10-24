package springjdbc.dto;

public class OrderToBasketDto {
	
	private String code;
	private int quantity;
	public OrderToBasketDto() {
	}
	public OrderToBasketDto(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
