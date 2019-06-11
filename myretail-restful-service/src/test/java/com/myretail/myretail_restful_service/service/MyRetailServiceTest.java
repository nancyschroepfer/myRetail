package com.myretail.myretail_restful_service.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.myretail_restful_service.data.DataException;
import com.myretail.myretail_restful_service.data.ProductRepository;
import com.myretail.myretail_restful_service.dto.CurrentPrice;
import com.myretail.myretail_restful_service.dto.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRetailServiceTest {

	@Autowired
	private MyRetailService service;
	
	@Autowired
	private ProductRepository productRepo;
	
	private CurrentPrice price;
	private Product product;
	
	@Before
	public void setUp() {
		price = new CurrentPrice(4.50, "USD");
		product = new Product(16752456, "Maxwell House Coffee", price);
		productRepo.save(product);
	}
	
	@After
	public void tearDown() {
		productRepo.delete(product);
	}
	
	@Test
	public void getProductById() {
		Product found = service.getProductById(product.getId());
		
		assertNotNull(found);
		assertTrue(found.getId() == product.getId());
		assertEquals(found.getName(), product.getName());
		assertTrue(found.getCurrentPrice().getValue() == product.getCurrentPrice().getValue());
		assertTrue(found.getCurrentPrice().getCurrencyCode().equals(product.getCurrentPrice().getCurrencyCode()));
	}
	
	@Test
	public void updateProduct() {
		double newPrice = 6.5;
		product.getCurrentPrice().setValue(newPrice);
		service.updateProduct(product, product.getId());
		
		Product found = productRepo.findById(product.getId());
		
		assertNotNull(found);
		assertTrue(found.getCurrentPrice().getValue() == newPrice);
	}
	
	@Test
	public void addProduct() {
		CurrentPrice addedPrice = new CurrentPrice(11.50, "USD");
		Product addedProduct = new Product(19852456, "5lb Jasmine Rice", addedPrice);
		
		service.addProduct(addedProduct);
		assertNotNull(productRepo.findById(addedProduct.getId()));
	}
	
	@Test
	public void deleteProduct() {
		service.deleteProduct(product.getId());
		
		assertNull(productRepo.findById(product.getId()));
	}
	
	@Test
	public void getProductsFromExternalApi() throws DataException {
		
		String name = service.getProductsFromExternalApi();
		
		assertTrue(name.equals("The Big Lebowski (Blu-ray)"));
	}
}
