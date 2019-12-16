package com.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.unittesting.business.ItemBusinessService;
import com.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest
class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ItemBusinessService itemBusinessService;
	
	@Test
	void testGetItem() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\": \"Ball\",\"price\": 120,\"quantity\": 10}"))
				.andReturn();
		
	}

	@Test
	void testGetBusinessItem() throws Exception {
		
		when(itemBusinessService.retrieveItem()).thenReturn(new Item(1, "Ball", 120, 10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id: 1,name:Ball,price: 120}"))
				.andReturn();
	}
	
	@Test
	void retrieveAllItemsTest() throws Exception {
		when(itemBusinessService.retrieveAll()).thenReturn(
					Arrays.asList(new Item[]{
							new Item(101, "ball", 120, 10),
							new Item(102, "pen", 10, 90)
					})
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/get-all-items")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:101,name:ball,price:120},{id:102,name:pen,price:10}]"))
				.andReturn();
	}
}
