package com.shopping.order.dao;

import org.springframework.data.repository.CrudRepository;

import com.shopping.order.entity.OrderInfo;

public interface OrderInfoRepository extends CrudRepository<OrderInfo, Integer> {

}
