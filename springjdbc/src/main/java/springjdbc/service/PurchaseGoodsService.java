package springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.DisplayBasketDao;
import springjdbc.dao.InsalesGoodsDao;
import springjdbc.dao.OrderToBasketDao;
import springjdbc.dao.SalesInfoDao;
import springjdbc.dao.StockInfoDao;
import springjdbc.entity.OrderInfoEntity;
import springjdbc.entity.SalesInfoEntity;

@Component
public class PurchaseGoodsService {
	@Autowired
	@Qualifier("displaybasketdao")
	private DisplayBasketDao displayBasketDao;
	
	public void setDisplayBasketDao(DisplayBasketDao displayBasketDao) {
		this.displayBasketDao = displayBasketDao;
	}
	
	@Autowired
	@Qualifier("insalesgoodsdao")
	private InsalesGoodsDao insalesGoodsDao;

	public void setInsalesGoodsDao(InsalesGoodsDao insalesGoodsDao) {
		this.insalesGoodsDao = insalesGoodsDao;
	}
	
	@Autowired
	@Qualifier("stockinfodao")
	private StockInfoDao stockInfoDao;
	
	public void setStockInfoDao(StockInfoDao stockInfoDao) {
		this.stockInfoDao = stockInfoDao;
	}
	
	@Autowired
	@Qualifier("salesinfodao")
	private SalesInfoDao salesInfoDao;
	
	public void setSalesInfoDao(SalesInfoDao salesInfoDao) {
		this.salesInfoDao = salesInfoDao;
	}
	
	@Autowired
	@Qualifier("ordertobasketdao")
	private OrderToBasketDao orderToBasketDao;

	public void setOrderToBasketDao(OrderToBasketDao orderToBasketDao) {
		this.orderToBasketDao = orderToBasketDao;
	}

	public void purchaseGoodsInBasket(String id) {
		List<OrderInfoEntity> orderInfoEntityList = displayBasketDao.retOrderInfoEntity(id, "N");
		
		int rawQuantity = 0;
		int totalQuantity = 0;
		int currentQuantity = 0;
		
		for(OrderInfoEntity orderInfoEntity: orderInfoEntityList) {
			String code = orderInfoEntity.getGoodsCode();
			rawQuantity = insalesGoodsDao.retNeededRawQuantity(code);
			totalQuantity = rawQuantity*orderInfoEntity.getOrderQuantity();
			currentQuantity = insalesGoodsDao.retCurrentRawQuantity(code);
			
			if(currentQuantity>=totalQuantity) {
				//stockinfo stock update
				int iRet1 = stockInfoDao.updateStockInfoByGoodsCode(code, currentQuantity-totalQuantity);
				if(iRet1 >0) {
					System.out.println("stock update");
				} else {
					System.out.println("stock update fail");;
				}
				
				//salesinfo insert or update
				updatesQuantityInSalesInfo(orderInfoEntity);
				
				//change orderinfo's confirmed by "Y"
				orderToBasketDao.updateConfirmedBySeq(orderInfoEntity.getSeq(), "Y");
				
			}  else {
				System.out.println("재고에 수량이 부족해서 "+orderInfoEntity.getGoodsCode()+" 의 구매가 진행되지 않았습니다");
			}
		}
	}
	
	private void updatesQuantityInSalesInfo(OrderInfoEntity orderInfo) {
		SalesInfoEntity salesInfoEntity = salesInfoDao.retSearchedSalesInfoByCode(orderInfo.getGoodsCode());
		int quantity = 0;
		if(salesInfoEntity == null) {
			salesInfoDao.insertSalesInfo(orderInfo);
		} else {
			quantity = salesInfoEntity.getOrderQuantity();
			
			salesInfoDao.updateSalesInfoByCode(orderInfo.getGoodsCode(), quantity+orderInfo.getOrderQuantity());
		}
	}

}
