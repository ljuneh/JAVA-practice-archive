package springjdbc.dao;

import springjdbc.entity.OrderInfoEntity;
import springjdbc.entity.SalesInfoEntity;

public interface SalesInfoDao {
	SalesInfoEntity retSearchedSalesInfoByCode(String code);
	
	int insertSalesInfo(OrderInfoEntity orderInfo);
	
	int updateSalesInfoByCode(String code, int quantity);

}
