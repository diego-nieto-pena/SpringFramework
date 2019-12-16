package com.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ListInterfaceTest {

	@Mock
	List<String> listMock;
	
	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		when(listMock.size()).thenReturn(8);
		assertEquals(8, listMock.size());
	}

	@Test
	void testGetItem() {
		when(listMock.get(0)).thenReturn("ItemOne").thenReturn("ItemTwo");
		assertEquals(listMock.get(0), "ItemOne");
		assertEquals(listMock.get(0), "ItemTwo");
	}
	
	@Test
	void verifyTest() {
		String str1 = listMock.get(0);
		String str2 = listMock.get(1);
		
		verify(listMock).get(0);
		
		verify(listMock, times(2)).get(anyInt());
		
		verify(listMock, atLeast(1)).get(anyInt());
		
		verify(listMock, atLeastOnce()).get(anyInt());
		
		verify(listMock, atMost(2)).get(anyInt());
		
		verify(listMock, never()).get(2);
	}
}
