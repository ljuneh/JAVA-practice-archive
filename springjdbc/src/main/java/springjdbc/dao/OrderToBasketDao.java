package springjdbc.dao;

import springjdbc.dto.OrderToBasketDto;

public interface OrderToBasketDao {
	int currentSeq();
	
	int insertOrderInfo(OrderToBasketDto orderToBasketDto, String id);
	
	int updateConfirmedByCode(String code, String confirmed, String id);
	
	int updateConfirmedBySeq(int seq, String confirmed);
}
