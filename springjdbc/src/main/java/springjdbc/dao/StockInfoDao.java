package springjdbc.dao;

import java.util.List;

import springjdbc.dto.StockInfoDto;

public interface StockInfoDao {
	String retRawCodeByCode(String code);
	
	int updateStockInfoByGoodsCode(String code, int quantity);
	
	List<StockInfoDto> retStockInfoDto();
	
	int initStock();

}
