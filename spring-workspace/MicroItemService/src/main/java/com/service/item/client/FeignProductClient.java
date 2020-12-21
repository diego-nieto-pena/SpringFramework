package com.service.item.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.commons.model.Product;

//@RibbonClient(name="products-service")
@FeignClient(name="products-service")
public interface FeignProductClient {

	@GetMapping(path="/find")
	public List<Product> findAll();
	
	@GetMapping(path="/find/{id}")
	public Product findById(@PathVariable Long id);
	
	@PostMapping("/create")
	public Product create(@RequestBody Product product);
	
	@PutMapping(path="/update/{id}")
	public Product update(@Valid @RequestBody Product product, @PathVariable Long id);
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable Long id);
}
