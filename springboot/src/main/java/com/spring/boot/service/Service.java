package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.dao.Dao;
@Component
public class Service {
	
	private Dao dao;
	
	@Autowired
	public Service(Dao dao) {
		System.out.println("service created");
		this.dao = dao;
	}
	
	public void save() {
		dao.create();
	}

}
