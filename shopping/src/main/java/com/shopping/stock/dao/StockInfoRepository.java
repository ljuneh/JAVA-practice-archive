package com.shopping.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.stock.entity.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, String> {

}
