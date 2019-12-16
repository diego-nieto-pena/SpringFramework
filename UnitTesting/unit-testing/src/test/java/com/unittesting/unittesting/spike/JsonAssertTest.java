package com.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResult = "{\"id\":1,\"name\":\"Ball\",\"price\":120,\"quantity\":10}";
	
	@Test
	void JsonAssetStrict() throws JSONException {
		
		String expected = "{id:1,name:Ball,price:120}";
		JSONAssert.assertEquals(expected, actualResult, false);
	}
}
