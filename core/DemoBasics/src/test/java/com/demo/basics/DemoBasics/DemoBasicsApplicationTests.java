package com.demo.basics.DemoBasics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.basics.DemoBasics.algo.BinarySearchImpl;

// Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=DemoBasicsApplication.class)
public class DemoBasicsApplicationTests {

	// Injects the bean from the ApplicationContext
	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBasicScenario() {
		int index = binarySearch.searchNumber(new int[] {4, 8, 9, 11, 3, 15, 1}, 3);
		assertEquals(1, index);
	}
}
