package springjdbc.dao;

import java.util.List;

import springjdbc.entity.OrderInfoEntity;

public interface DisplayBasketDao {
	
	List<OrderInfoEntity> retOrderInfoEntity(String id, String confirmed);
	
	String retGoodsNameByCode(String code);
	
	int retPriceByCode(String code);
	

}
