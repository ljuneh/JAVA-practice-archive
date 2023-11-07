package com.shopping.display.dto;

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
public class InsalesGoodsDto {
	private String goodsCode;
	
	private String goodsName;
	
	private int price;
	
	private int goodsQuantity;
	
	private String imageSource;
	
}
