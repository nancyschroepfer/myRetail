package com.myretail.myretail_restful_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.myretail_restful_service.data.DataException;
import com.myretail.myretail_restful_service.dto.Product;
import com.myretail.myretail_restful_service.service.MyRetailService;


@RestController
@RequestMapping("/product")
public class MyRetailController {
	
	@Autowired
	private MyRetailService service;
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return service.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
		return service.updateProduct(product, id);
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable long id) {
		service.deleteProduct(id);
	}
	
	public String getProductsFromExternalApi() throws DataException {
		return service.getProductsFromExternalApi();
	}
}
