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
//
//select goodscode, goodsname, price
//from insalesgoods
//where UTL_MATCH.jaro_winkler_similarity(goodsname, '잡채') > 70
//order by goodscode asc

//select i.goodscode, i.goodsname, i.price, s.goodsquantity, g.imagesource
//from insalesgoods i, stockinfo s, goodsimage g
//where UTL_MATCH.jaro_winkler_similarity(i.goodsname, '잡채') > 60
//and i.goodscode = s.goodscode
//and i.goodscode = g.goodscode
//order by goodscode asc