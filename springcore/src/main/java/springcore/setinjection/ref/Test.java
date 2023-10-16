package springcore.setinjection.ref;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springcore/setinjection/ref/refconfig.xml");
		
		Student student = (Student)ctx.getBean("student");
		System.out.println(student.getScores());
		
		ShoppingCart cart = (ShoppingCart)ctx.getBean("shoppingcart");
		ArrayList<Item> itemList = cart.getItemList();
		
		for(Item item: itemList) {
			System.out.println(item);
		}
		
		ctx.close();
		
	}

}
