package com.service.item.service;

import java.util.List;
import java.util.Optional;

import com.commons.model.Product;
import com.service.item.model.Item;

public interface ItemService {

	public List<Item> getItems();
	
	public Optional<Item> getItemById(Long id, Integer quantity);
	
	public Product getProductById(Long id);
	
	public Product save(Product product);
	
	public Product update(Product update, Long id);
	
	public void delete(Long id);
}
