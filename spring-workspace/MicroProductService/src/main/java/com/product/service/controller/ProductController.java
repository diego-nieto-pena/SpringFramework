package com.product.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.model.Product;
import com.product.service.service.IProductService;
import com.service.product.exception.ProductNotFoundException;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private Environment environment;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping(path="/find")
	public List<Product> findAll() {
		return productService
				.findAll()
				.stream()
				.map(product -> {
					//product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
					product.setPort(port);
					return product;
				})
				.collect(Collectors.toList());
	}
	
	@GetMapping(path="/find/{id}")
	public Product getProductById(@PathVariable Long id) {
		Product product = productService.findById(id);
		if(product != null) {
			//product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}
		return null;
	}
	
	@PostMapping(path="/create")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		Product newProduct = productService.save(product);
		
		if(newProduct != null) {
			return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/update/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) throws ProductNotFoundException {
		Product storedProduct = productService.findById(id);
		System.out.println(storedProduct);
		if(storedProduct == null) {
			throw new ProductNotFoundException("The requested product isn't present!");
		} else {
			storedProduct.setName(product.getName());
			storedProduct.setPrice(product.getPrice());
			storedProduct.setCreateAt(product.getCreateAt());
			productService.save(storedProduct);
			return new ResponseEntity<Product>(storedProduct, HttpStatus.CREATED);
		}
	}
	
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			productService.deleteById(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
