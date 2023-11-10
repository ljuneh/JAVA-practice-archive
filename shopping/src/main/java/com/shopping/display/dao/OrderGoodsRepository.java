package com.shopping.display.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.shopping.display.entity.OrderGoods;

public interface OrderGoodsRepository extends JpaRepository<OrderGoods, String> {

}
