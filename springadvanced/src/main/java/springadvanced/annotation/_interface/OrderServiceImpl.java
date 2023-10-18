package springadvanced.annotation._interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;
	

	@Override
	public void placeOrder() {
		System.out.println("Inside Order Service placeOrder()");
		dao.createOrder();
		
	}


	public OrderDao getDao() {
		return dao;
	}


	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	

}
