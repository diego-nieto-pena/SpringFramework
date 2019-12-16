package com.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.unittesting.unittesting.repository.DataService;

@RunWith(MockitoJUnitRunner.class)
public class CountingServiceTest {

	@Mock
	DataService dataService;
	
	@InjectMocks
	CountingService countService;

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void dataServiceCountingMockTest() {
		when(dataService.getData()).thenReturn(new int[] {1, 2, 3, 4});
		assertEquals(10, countService.sumNumbers());
	}
	
	@Test
	public void dataServiceEmptyArrayTest() {
		when(dataService.getData()).thenReturn(new int[] {});
		assertEquals(0, countService.sumNumbers());
	}
	
	@Test
	public void dataServiceOneElemArrayTest() {
		when(dataService.getData()).thenReturn(new int[] {5});
		assertEquals(5, countService.sumNumbers());
	}

}
