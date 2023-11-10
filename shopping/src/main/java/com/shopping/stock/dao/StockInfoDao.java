package com.shopping.stock.dao;

import org.apache.ibatis.annotations.Param;

public interface StockInfoDao {
	Integer initStockQuantity(@Param("quantity") int quantity);
}
