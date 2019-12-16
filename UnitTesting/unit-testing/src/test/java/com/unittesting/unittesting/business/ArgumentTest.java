package com.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ArgumentTest {

	@Mock
	CountingService service;
	
	@BeforeEach
	void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testArgumentCapture() {
		service.sumNNumbers(21);
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(service).sumNNumbers(captor.capture());
		
		assertEquals(new Integer(21), captor.getValue());
	}

	@Test
	void testMultipleArgumentCapture() {
		service.sumNNumbers(21);
		service.sumNNumbers(7);
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(service, times(2)).sumNNumbers(captor.capture());
		
		List<Integer> allValues = captor.getAllValues();
		
		assertEquals(new Integer(21), allValues.get(0));
		assertEquals(new Integer(7), allValues.get(1));
	}
}
