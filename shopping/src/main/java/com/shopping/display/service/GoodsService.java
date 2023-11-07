package com.shopping.display.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shopping.display.dao.DisplayDao;
import com.shopping.display.dto.InsalesGoodsDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsService {
	
	private final DisplayDao displayDao;
	
	public List<InsalesGoodsDto> retDisplayList() {
		List<InsalesGoodsDto> insalesList = null;
		
		insalesList = displayDao.retInsalesGoodsDtoList();
		
		
		return insalesList;
	}
	

}
