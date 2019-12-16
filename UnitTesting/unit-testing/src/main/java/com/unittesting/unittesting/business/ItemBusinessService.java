package com.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.repository.ItemRepository;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item retrieveItem() {
		return new Item(1, "Ball", 120, 10);
	}
	
	public List<Item> retrieveAll() {
		List<Item> itemList = itemRepository.findAll();
		
		for(Item item : itemList) {
			item.setValue(item.getQuantity() * item.getPrice());
		}
		
		return itemList;
	}
}
