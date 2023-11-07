package com.shopping.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.shopping.login.dto.RegisterDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "userinfo")
@DynamicInsert
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
	@Column(name="username")
	private String name;
	
	public static UserInfo createUserInfo(RegisterDto registerDto) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(registerDto.getId());
		userInfo.setPassword(registerDto.getPassword());
		userInfo.setEmail(registerDto.getEmail());
		userInfo.setName(registerDto.getName());
		
		return userInfo;
	}
}
