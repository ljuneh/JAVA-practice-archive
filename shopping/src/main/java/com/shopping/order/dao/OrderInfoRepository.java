package com.shopping.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.shopping.login.entity.UserInfo;
import com.shopping.order.entity.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
	List<OrderInfo> findAllByUserInfoAndConfirmedOrderByOrderSeqAsc(UserInfo userInfo, String confirmed);
}
