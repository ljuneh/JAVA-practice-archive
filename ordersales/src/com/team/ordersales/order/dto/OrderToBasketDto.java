package com.team.ordersales.order.dto;

public class OrderToBasketDto {
	
	private String code;
	private String name;
	private String price;
	private String quantity;
	private String raw;
	private String current;
	private String totalprice;
	public OrderToBasketDto() {
	}
	public OrderToBasketDto(String code, String name, String price, String quantity, String raw, String current,
			String totalprice) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.raw = raw;
		this.current = current;
		this.totalprice = totalprice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	
	

}
