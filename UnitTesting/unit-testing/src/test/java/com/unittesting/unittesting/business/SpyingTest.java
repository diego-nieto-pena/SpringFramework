package com.unittesting.unittesting.business;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SpyingTest {

	@Test
	void testMock() {
		ArrayList list = mock(ArrayList.class);
		
		System.out.println(list.get(0));
		
		System.out.println(list.size());
		
		list.add("test");
		list.add("test2");
		
		System.out.println(list.size());
		when(list.size()).thenReturn(5);
		
		System.out.println(list.size());
		
	}

	@Test
	public void spyTest() {
		ArrayList listSpy = spy(ArrayList.class);
		
		listSpy.add("test1");
		System.out.println(listSpy.size());
		
		System.out.println(listSpy.get(0));
		
		listSpy.add("test2");
		listSpy.add("test3");
		
		System.out.println(listSpy.size());
		
		when(listSpy.size()).thenReturn(7);
		System.out.println(listSpy.size());
	}
}
