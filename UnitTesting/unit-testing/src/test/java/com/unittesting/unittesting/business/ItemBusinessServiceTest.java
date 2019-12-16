package com.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@Mock
	private ItemRepository itemRepository;
	
	@InjectMocks
	ItemBusinessService itemBusinessService;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void retrieveAllItemsFromRepositoryTest() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item[]{
				new Item(101, "ball", 120, 10),
				new Item(102, "pen", 10, 90)
		}));
		
		List<Item> items = itemBusinessService.retrieveAll();
		
		assertEquals(1200, items.get(0).getValue());
		assertEquals(900, items.get(1).getValue());
	}
}
