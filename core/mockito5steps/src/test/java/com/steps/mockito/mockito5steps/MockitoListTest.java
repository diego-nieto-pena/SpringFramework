package com.steps.mockito.mockito5steps;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoListTest {

	@Test
	public void testListInterface() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		
		when(list.get(Mockito.anyInt())).thenReturn("SomeStringValue");
		assertEquals(list.get(12), "SomeStringValue");
	}
}
