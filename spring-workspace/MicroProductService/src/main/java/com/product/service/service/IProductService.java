package com.product.service.service;

import java.util.List;

import com.commons.model.Product;

public interface IProductService {

	List<Product> findAll();
	
	Product findById(Long id);
	
	Product save(Product product);
	
	void deleteById(Long id);
}
