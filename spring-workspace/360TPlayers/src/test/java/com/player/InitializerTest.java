package com.player;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class InitializerTest {

	@Test
	public void test_threadNames() {
		Initializer.initialize();
		
		assertEquals("Initiator", Initializer.initiator.getName());
		assertEquals("Receptor", Initializer.receptor.getName());
	}
}
