package com.player;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

	private ServerSocket socket;
	
	@BeforeEach
	public void init() throws IOException {
		 socket = new ServerSocket(5000);
	}
	
	@Test
	public void test_shouldThrowBindException() {
		String[] args = {};
		Main.main(args);
		Assertions.assertThrows(BindException.class, () -> {
			Main.main(args);
		  });
	}
}
