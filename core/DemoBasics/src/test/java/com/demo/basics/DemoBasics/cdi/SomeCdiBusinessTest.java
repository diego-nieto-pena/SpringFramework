package com.demo.basics.DemoBasics.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=DemoBasicsCdiApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	@Mock
	SomeCdiDao someCdiDao;
	@InjectMocks
	SomeCdiBusiness someCdiBusiness;
	
	@Test
	public void test() {
		Mockito.when(someCdiDao.getData()).thenReturn(new int[] {1,2,3,4,5});
		assertEquals(5, someCdiBusiness.getLargetNumber());
	}
}
