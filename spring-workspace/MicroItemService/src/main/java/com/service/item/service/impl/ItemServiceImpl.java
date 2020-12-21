package com.service.item.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.commons.model.Product;
import com.service.item.model.Item;
import com.service.item.service.ItemService;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<Item> getItems() {
		List<Product> productList = Arrays.asList(restClient
								.getForObject("http://products-service/find", Product[].class));
		return productList.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Optional<Item> getItemById(Long id, Integer quantity) {
		
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		
		Product product = restClient.getForObject("http://products-service/find/{id}", 
				Product.class, pathVariables);
		
		if(product!=null) {
			return Optional.of(new Item(product, quantity));
		}
		
		return Optional.empty();
	}

	@Override
	public Product getProductById(Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		return restClient.getForObject("http://products-service/find/{id}", Product.class, pathVariables);
	}
	
	@Override
	public Product save(Product product) {
		HttpEntity<Product> body = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = restClient.exchange("http://products-service/create", HttpMethod.POST, body , Product.class);
		return response.getBody();
	}

	@Override
	public Product update(Product product, Long id) {
		HttpEntity<Product> body = new HttpEntity<Product>(product);
		
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		
		ResponseEntity<Product> response = restClient.exchange("http://products-service/update/{id}", HttpMethod.PUT,
				body, Product.class, pathVariables);
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		
		restClient.delete("http://products-service/delete/{id}", pathVariables);
	}

}
