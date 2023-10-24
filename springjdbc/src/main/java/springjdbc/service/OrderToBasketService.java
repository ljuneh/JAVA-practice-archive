package springjdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.OrderToBasketDao;
import springjdbc.dto.OrderToBasketDto;

@Component
public class OrderToBasketService {
	@Autowired
	@Qualifier("ordertobasketdao")
	private OrderToBasketDao orderToBasketDao;
	
	public void setOrderToBasketDao(OrderToBasketDao orderToBasketDao) {
		this.orderToBasketDao = orderToBasketDao;
	}



	public void orderGoods(OrderToBasketDto orderToBasketDto, String id) {
		int iRet = orderToBasketDao.insertOrderInfo(orderToBasketDto, id);
		if(iRet>0) {
			System.out.println("주문 선택 성공");
		} else {
			System.out.println("update fail");
		}
	}
	
	public void deleteGoodsInBasketByCode(String code, String id) {
		int iRet = orderToBasketDao.updateConfirmedByCode(code, "C", id);
		if(iRet>0) {
			System.out.println("주문 취소 성공");
		} else {
			System.out.println("update fail");
		}
	}

}
