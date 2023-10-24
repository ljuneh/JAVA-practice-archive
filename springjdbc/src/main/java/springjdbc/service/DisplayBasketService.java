package springjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.DisplayBasketDao;
import springjdbc.dao.StockInfoDao;
import springjdbc.dto.DisplayBasketDto;
import springjdbc.entity.OrderInfoEntity;

@Component
public class DisplayBasketService {
	
	@Autowired
	@Qualifier("displaybasketdao")
	private DisplayBasketDao displayBasketDao;
	
	public void setDisplayBasketDao(DisplayBasketDao displayBasketDao) {
		this.displayBasketDao = displayBasketDao;
	}
	
	@Autowired
	@Qualifier("stockinfodao")
	private StockInfoDao stockInfoDao;
	
	public void setStockInfoDao(StockInfoDao stockInfoDao) {
		this.stockInfoDao = stockInfoDao;
	}


	public List<DisplayBasketDto> retGoods(String id) {
		List<OrderInfoEntity> orderInfoEntityList = displayBasketDao.retOrderInfoEntity(id, "N");
		
		List<DisplayBasketDto> displayBasketDtoList = new ArrayList<DisplayBasketDto>();
		
		String name = "";
		int price = 0;
		int quantity = 0;
		
		for(OrderInfoEntity orderInfoEntity: orderInfoEntityList) {
			DisplayBasketDto displayBasketDto = new DisplayBasketDto();
			
			name = displayBasketDao.retGoodsNameByCode(orderInfoEntity.getGoodsCode());
			price = displayBasketDao.retPriceByCode(orderInfoEntity.getGoodsCode());
			quantity = orderInfoEntity.getOrderQuantity();
			
			displayBasketDto.setGoodsName(name);
			displayBasketDto.setSeq(orderInfoEntity.getSeq());
			displayBasketDto.setOrderQuantity(quantity);
			displayBasketDto.setOrderDate(orderInfoEntity.getOrderDate());
			displayBasketDto.setPrice(price);
			displayBasketDto.setTotalprice(price*quantity);
			
			displayBasketDtoList.add(displayBasketDto);
		}
		
		return displayBasketDtoList;
	}

}
