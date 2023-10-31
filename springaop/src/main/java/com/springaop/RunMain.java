package com.springaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunMain {
	
	private static ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/com/springaop/config.xml");
		
		ProductService productService = (ProductService) ctx.getBean("productService");
		
		productService.multiply(0, 0);
		
		ctx.close();
		
	}

}
