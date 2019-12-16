package com.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void jsonPathTest() {
		String jsonResponse = "[{\"id\" : 10000, \"name\":\"Pencil\", \"quantity\":23},\r\n" + 
				"{\"id\" : 10001, \"name\":\"Rule\", \"quantity\":13},\r\n" + 
				"{\"id\" : 10002, \"name\":\"Eraser\", \"quantity\":3}\r\n" + 
				"]";
		
		DocumentContext context = JsonPath.parse(jsonResponse);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10000, 10001, 10002);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(context.read("$.[?(@.quantity==13)]").toString());
	}
}
