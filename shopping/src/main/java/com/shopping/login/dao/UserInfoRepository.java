package com.shopping.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.shopping.login.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
