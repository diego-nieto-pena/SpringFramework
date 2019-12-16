package com.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unittesting.unittesting.business.ItemBusinessService;
import com.unittesting.unittesting.model.Item;

@RestController
public class ItemController {

	@Autowired
	ItemBusinessService itemBusinessService; 
	
	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1, "Ball", 120, 10);
	}
	
	@GetMapping(path="/item-from-business")
	public Item itemFromBusiness() {
		return itemBusinessService.retrieveItem();
	}
	
	@GetMapping(path="/get-all-items")
	public List<Item> getAllItems() {
		return itemBusinessService.retrieveAll();
	}
}
