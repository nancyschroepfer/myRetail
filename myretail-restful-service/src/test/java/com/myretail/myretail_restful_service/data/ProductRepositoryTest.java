package com.myretail.myretail_restful_service.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.myretail_restful_service.dto.CurrentPrice;
import com.myretail.myretail_restful_service.dto.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepo;
	private CurrentPrice price;
	private Product product;

	@Before
	public void setUp() {
		price = new CurrentPrice(123, "USD");
		product = new Product(16752456, "Maxwell House Coffee", price);
	}
	
	@Test
	public void findById() {
		productRepo.save(product);
		Product found = productRepo.findById(product.getId());
		
		assertTrue(found != null);
		assertTrue(found.getId() == product.getId());
		assertEquals(found.getName(), product.getName());
		assertTrue(found.getCurrentPrice().getValue() == product.getCurrentPrice().getValue());
		assertEquals(found.getCurrentPrice().getCurrencyCode(), product.getCurrentPrice().getCurrencyCode());
	}
	
	@After
	public void tearDown() {
		productRepo.delete(product);
	}
}
