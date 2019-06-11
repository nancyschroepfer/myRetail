package com.myretail.myretail_restful_service.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private long id;
	private String name;
	private CurrentPrice currentPrice;
	
	public Product() {
		
	}
	
	public Product(long id, String name, CurrentPrice currentPrice) {
		this.id = id;
		this.name = name;
		this.currentPrice = currentPrice;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
}
