package com.myretail.myretail_restful_service.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.myretail_restful_service.dto.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{

	public Product findById(long id);
}
