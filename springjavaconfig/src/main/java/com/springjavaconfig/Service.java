package com.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {
	
	@Autowired
	private Dao dao;
	
	public void save() {
		dao.create();
	}
	
	public void hello() {
		System.out.println("obj create");
	}
	
	public void goodbye() {
		System.out.println("obj extinction");
	}

}
