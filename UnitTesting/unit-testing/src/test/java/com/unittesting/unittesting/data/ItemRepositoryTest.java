package com.unittesting.unittesting.data;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.repository.ItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository repository;
	
	@Test
	void testFindAll() {
		int size = repository.findAll().size();
		assertEquals(4, size);
	}
	
	@Test
	void testFindById() throws JSONException {
		Optional<Item> itemOpt = repository.findById(1);
		
		Gson gson = new Gson();
		
		String actualJson = gson.toJson(itemOpt.get());
		String expectedJson = "{id:1, name:ball, price:120, quantity:100}";
		JSONAssert.assertEquals(expectedJson, actualJson, false);
	}
}
