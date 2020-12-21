package com.service.item.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.commons.model.Product;
import com.service.item.client.FeignProductClient;
import com.service.item.model.Item;
import com.service.item.service.ItemService;

@Service("feignItemService")
@Primary
public class FeignItemServiceImpl implements ItemService {

	@Autowired
	private FeignProductClient feignProductClient;
	
	@Autowired
	private Environment environment;
	
	@Override
	public List<Item> getItems() {
		
		return feignProductClient.findAll()
		.stream()
		.map(p -> new Item(p, 1, getPort()))
		.collect(Collectors.toList());
	}

	@Override
	public Optional<Item> getItemById(Long id, Integer quantity) {
		Product product =  feignProductClient.findById(id);
		
		if(product != null) {
			Item item = new Item(product, quantity, getPort());
			return Optional.of(item);
		}
		
		return Optional.empty();
	}
	
	private Integer getPort() {
		return Integer.parseInt(environment.getProperty("local.server.port"));
	}

	@Override
	public Product save(Product product) {
		return feignProductClient.create(product);
	}

	@Override
	public Product update(Product product, Long id) {
		return feignProductClient.update(product, id);
	}

	@Override
	public void delete(Long id) {
		feignProductClient.delete(id);
	}

	@Override
	public Product getProductById(Long id) {
		return feignProductClient.findById(id);
	}
}
