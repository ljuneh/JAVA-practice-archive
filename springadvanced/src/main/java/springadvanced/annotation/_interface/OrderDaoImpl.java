package springadvanced.annotation._interface;

import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao{

	@Override
	public void createOrder() {
		System.out.println("Inside Order DAO createOrder()");
		
	}

}
