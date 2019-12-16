package com.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {

	@Test
	public void assertJTest() {
		List<Integer> numbers = Arrays.asList(12, 15, 67);
		
		assertThat(numbers).hasSize(3)
				.contains(12, 67)
				.allMatch(x -> x > 10)
				.allMatch(x -> x < 99)
				.noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDEFGHIJKLMN")
			.contains("IJK")
			.startsWith("ABC")
			.endsWith("MN");
	}
}
