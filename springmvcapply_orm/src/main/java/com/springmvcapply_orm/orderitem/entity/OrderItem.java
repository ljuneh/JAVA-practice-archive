package com.springmvcapply_orm.orderitem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springmvcapply_orm.item.entity.Item;
import com.springmvcapply_orm.orders.entity.Orders;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orderitem")
@Getter
@Setter
public class OrderItem {
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Orders orders;
	
	@Column(name = "order_price")
	private int orderPrice; // 주문가격
	
	private int count;

}
