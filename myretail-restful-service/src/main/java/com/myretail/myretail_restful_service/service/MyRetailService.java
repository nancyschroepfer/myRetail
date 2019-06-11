package com.myretail.myretail_restful_service.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myretail_restful_service.data.DataException;
import com.myretail.myretail_restful_service.data.ProductRepository;
import com.myretail.myretail_restful_service.dto.Product;

@Service
public class MyRetailService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product getProductById(long id) {
		return productRepository.findById(id);
	}
	
	public Product updateProduct(Product product, long id) {
		return productRepository.save(product);
	}
	
	public Product addProduct(Product product) {
		return productRepository.insert(product);
	}
	
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	
	public String getProductsFromExternalApi() throws DataException {
				
		RestTemplate restTemplate = new RestTemplate();
		String endPoint = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		ResponseEntity<String> response = restTemplate.getForEntity(endPoint, String.class);
		
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new DataException("Error Retrieving Data from Redsky");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		String name = null;
		
		try {
			node = mapper.readTree(response.getBody());
			name = node.path("product").path("item").path("product_description").path("title").asText();
		}
		catch (IOException io) {
			throw new DataException("Error Retrieving Data Value");
		}
		
		return name;
	}
}
