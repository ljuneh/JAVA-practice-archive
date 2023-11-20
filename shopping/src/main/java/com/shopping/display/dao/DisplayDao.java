package com.shopping.display.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.display.dto.InsalesGoodsDto;

public interface DisplayDao {
	List<InsalesGoodsDto> retInsalesGoodsDtoList();
	
	List<InsalesGoodsDto> retsearchedGoodsDtoList(@Param("name") String name);
}
