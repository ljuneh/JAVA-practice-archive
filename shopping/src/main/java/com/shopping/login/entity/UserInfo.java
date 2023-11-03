package com.shopping.login.entity;

import javax.persistence.Column;
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
@Table(name = "userinfo")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {
	@Id
	@Column(name="userid")
	private String id;
	@Column(name="userpassword")
	private String password;
	private String auth;
	private String email;
	
}
