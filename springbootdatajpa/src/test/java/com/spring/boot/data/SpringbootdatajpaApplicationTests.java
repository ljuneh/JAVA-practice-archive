package com.spring.boot.data;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.spring.boot.data.entities.Product;
import com.spring.boot.data.repos.ProductRepository;

@SpringBootTest
class SpringbootdatajpaApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	
	@Autowired
	ApplicationContext ctx;
	
//	@Test
	void saveProduct() {
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		
//		Product product = new Product();
//		product.setId(0);
//		product.setName("상품0");
//		product.setDescription("상품0");
//		product.setPrice(1000);
//		
//		productRepository.save(product);
		Product product = null;
//		product = productRepository.findById(1).orElseThrow(EntityNotFoundException::new);
		product = productRepository.findById(1).orElse(product);
		
		System.out.println(product);
		
		product.setPrice(1);
		productRepository.save(product);
	
	}
	
	@Test
	void customJpaProduct() {
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		
		List<Product> productList = productRepository.findByName("상품1");
		
		for(Product pro: productList) {
			System.out.println(pro);
		}
	}

}
