package com.spring.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.spring.boot.service.Service;

@SpringBootTest
class SpringbootApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void serviceTest() {
		Service service = context.getBean(Service.class);
		
		service.save();
	}

}
