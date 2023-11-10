package com.shopping.order.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfoDto {
	
	private int seq;
	
	private String goodsName;
	
	private int price;
	
	private int orderQuantity;
	
	private Date orderDate;
	
	private int totalPrice;

}
