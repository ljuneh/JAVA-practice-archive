package com.shopping.stock.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.shopping.display.dao.OrderGoodsRepository;
import com.shopping.stock.dao.StockInfoDao;
import com.shopping.stock.dao.StockInfoRepository;
import com.shopping.stock.dto.StockInfoDto;
import com.shopping.stock.entity.StockInfo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {
	
	private final StockInfoRepository stockInfoRepository;
	private final OrderGoodsRepository orderGoodsRepository;
	private final StockInfoDao stockInfoDao;
	
	public List<StockInfoDto> retStockInfoDtoList() {
		List<StockInfoDto> stockInfoDtoList = new ArrayList<StockInfoDto>();
		List<StockInfo> stockInfoList = stockInfoRepository.findAll();
		String goodsCode = "";
		String goodsName = "";
		int goodsQuantity = 0;
		for(StockInfo stockInfo : stockInfoList) {
			goodsCode = stockInfo.getGoodsCode();
			goodsQuantity = stockInfo.getGoodsQuantity();
			StockInfoDto stockInfoDto = new StockInfoDto();
			
			stockInfoDto.setGoodsCode(goodsCode);
			stockInfoDto.setGoodsQuantity(goodsQuantity);
			goodsName = orderGoodsRepository.getReferenceById(goodsCode).getGoodsName();
			stockInfoDto.setGoodsName(goodsName);
			
			stockInfoDtoList.add(stockInfoDto);
		}
		
		return stockInfoDtoList ;
		
	}
	
	public void changeStockQuantity(StockInfo stockInfo) {
//		StockInfo stockInfo = new StockInfo(goodsCode, goodsQuantity);
		stockInfoRepository.save(stockInfo);
	}
	
	public void initStock(int quantity) {
		stockInfoDao.initStockQuantity(quantity);
	}

}
