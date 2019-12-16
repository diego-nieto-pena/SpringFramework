package com.steps.mockito.mockito5steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessTest {

	@Mock
	DataService dataService;
	
	@InjectMocks
	SomeBusiness business;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetTheGreatest() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {12, 44, 99, 34});
		assertEquals(99, business.getTheGreatest());
	}

}
