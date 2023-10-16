package com.khinfo.spring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/khinfo/spring/springcore/config.xml");
		
		Employee employee = (Employee) ctx.getBean("emp");
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		
		Hospital hospital = (Hospital) ctx.getBean("hospital");
		System.out.println(hospital.getId());
		
		for(int item: hospital.getList()) {
			System.out.println(item);
		}

	}

}
