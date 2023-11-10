package com.shopping.stock.dto;

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
public class StockInfoDto {
	private String goodsCode;
	
	private String goodsName;
	
	private int goodsQuantity;

}
