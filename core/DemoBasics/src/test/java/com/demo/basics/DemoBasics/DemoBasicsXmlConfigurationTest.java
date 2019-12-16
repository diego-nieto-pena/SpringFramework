package com.demo.basics.DemoBasics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.basics.DemoBasics.algo.BinarySearchImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="/applicationContextTest.xml")
public class DemoBasicsXmlConfigurationTest {
	
	@Autowired
	BinarySearchImpl binarySearch;

	@Test
	public void basicCaseTest() {
		int actualResult = binarySearch.searchNumber(new int[] {5,7,2,6,0,11,33}, 11);
		assertEquals(5, actualResult);
	}
}