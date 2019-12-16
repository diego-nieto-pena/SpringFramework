package com.unittesting.unittesting.spike;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {
	
	@Test
	public void hamcrestMatchers() {
		List<Integer> numbers = Arrays.asList(12, 13, 46);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12, 46));
		//assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(99)));
		
		//assertThat("", isEmptyString());
		assertThat("ABCDE", containsString("BCD"));
		assertThat("ABCDE", startsWith("AB"));
		assertThat("ABCDE", endsWith("DE"));
	}
}
