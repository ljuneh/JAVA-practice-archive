package springjdbc.dto;

import java.util.Date;

public class DisplayBasketDto {
	
	private int seq;
	private String goodsName;
	private int orderQuantity;
	private int price;
	private int totalprice;
	private Date orderDate;
	public DisplayBasketDto() {
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("상품명: %s, 수량: %d, 개별가격: %d, 총 가격: %d, 주문 날짜: %s", getGoodsName(), getOrderQuantity(), getPrice(), getTotalprice(), getOrderDate());
	}

}
