package com.shopping.login.dao;

import org.springframework.data.repository.CrudRepository;

import com.shopping.login.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

}
