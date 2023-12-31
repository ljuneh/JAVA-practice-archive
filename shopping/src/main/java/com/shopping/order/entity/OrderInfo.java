package com.shopping.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.shopping.display.entity.OrderGoods;
import com.shopping.login.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@SequenceGenerator(
        name = "SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ",
        allocationSize = 1
)
@Setter
@Entity
@Table(name = "orderinfo")
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfo {
	@Id
	@Column(name="orderseq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int orderSeq;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodscode")
	private OrderGoods orderGoods;
	
	@Column(name="orderquantity")
	private int orderQuantity;
	
	private String confirmed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserInfo userInfo;
	
	@Column(name="orderdate")
	private Date orderDate;

}
