package com.service.item.model;

import com.commons.model.Product;

public class Item {

	private Product product;
	private Integer quantity;
	private Integer port;
	
	public Item() {
		
	}

	public Item(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Item(Product product, Integer quantity, Integer port) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.port = port;
	}

	public Double getTotal() {
		return product.getPrice() * quantity.doubleValue();
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
}
