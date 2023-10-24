package springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.StockInfoDao;
import springjdbc.dto.StockInfoDto;

@Component
public class DisplayStockService {
	
	@Autowired
	@Qualifier("stockinfodao")
	private StockInfoDao stockInfoDao;
	
	public void setStockInfoDao(StockInfoDao stockInfoDao) {
		this.stockInfoDao = stockInfoDao;
	}

	public List<StockInfoDto> retStock() {
		List<StockInfoDto> stockInfoDtoList = stockInfoDao.retStockInfoDto();
		return stockInfoDtoList;
	}
	
	public void initStock() {
		int iRet = stockInfoDao.initStock();
		
		if(iRet>0) {
			System.out.println("stock init success");
		} else {
			System.out.println("stock init fail");
		}
	}

}
