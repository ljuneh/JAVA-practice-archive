package com.springmvcapply_orm.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // 상품코드
	
	@Column(name = "item_nm", nullable = false, length = 50)
	private String itemNm; // 상품명
	
	@Column(name = "price", nullable = false)
	private int price; // 가격
	
	@Column(name = "stock_number", nullable = false)
	private int stockNumber; // 재고 수량
	
	@Lob
	@Column(name = "item_details", nullable = false)
	private String itemDetail; // 상품 상세 설명
	
	@Column(name = "item_sell_status", nullable = false)
	private String itemSellStatus; // 상품 판매 상태

}
