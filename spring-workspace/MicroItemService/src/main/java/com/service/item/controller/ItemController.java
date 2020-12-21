package com.service.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.item.exception.ItemNotFoundException;
import com.service.item.model.Item;
import com.service.item.service.ItemService;

@RefreshScope
@RestController
public class ItemController {

	@Autowired
	@Qualifier("feignItemService")
	private ItemService itemService;
	
	@Value("${configuration.text}")
	private String textProperty;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path="/query")
	public List<Item> findAll() {
		return itemService.getItems();
	}
	@HystrixCommand(fallbackMethod = "getDefaultItem")
	@GetMapping(path="/query/{id}/quantity/{quantity}")
	public Item getItemById(@PathVariable Long id, @PathVariable Integer quantity) throws ItemNotFoundException {
		
		Optional<Item> itemOpt = itemService.getItemById(id, quantity);
		if(!itemOpt.isPresent()) {
			System.out.println("ITEM NOT FOUND");
			throw new ItemNotFoundException("The Item doesn't exists ID: " + id);
		}
		return itemOpt.get();
	}
	
	public Item getDefaultItem(Long id, Integer quantity) {
		Item item = new Item();
		
		Product product = new Product();
		product.setId(1L);
		product.setName("Wireless mouse");
		product.setPrice(12.00);
		
		item.setProduct(product);
		item.setQuantity(35);
		return item;
	}

	@GetMapping(path="/props")
	public ResponseEntity<Map<String, String>> getConfProperties(@Value("${server.port}") String port) {
		
		Map<String, String> props = new HashMap<>();
		
		String[] profiles = environment.getActiveProfiles();
		if(profiles.length > 0) {
			props.put("user.name", environment.getProperty("configuration.user.name"));
			props.put("user.email", environment.getProperty("configuration.user.email"));
		}
			
		props.put("port", port);
		props.put("text", textProperty);
		return new ResponseEntity<Map<String, String>>(props, HttpStatus.OK);
	}
	
	@PostMapping(path="/create")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		Product newProduct = itemService.save(product);
		if(newProduct!= null) {
			return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable Long id) {
		Product storedProduct = itemService.getProductById(id);
		
		if(storedProduct != null) {
			storedProduct.setCreateAt(product.getCreateAt());
			storedProduct.setName(product.getName());
			storedProduct.setPrice(product.getPrice());
			itemService.save(storedProduct);
			
			return new ResponseEntity<Product>(storedProduct, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
		Product product = itemService.getProductById(id);
		if(product != null) {
			itemService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
