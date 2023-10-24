package springjdbc.dao;

import java.util.List;

import springjdbc.entity.InsalesGoodsEntity;

public interface InsalesGoodsDao {
	List<InsalesGoodsEntity> retInsalesGoodsEntity();
	
	int retCurrentRawQuantity(String code);
	
	int retNeededRawQuantity(String code);

}
