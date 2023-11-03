package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "member_new")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
	@Id
	private int id;
	
	private String password;
	private String name;
	private String address;
}
