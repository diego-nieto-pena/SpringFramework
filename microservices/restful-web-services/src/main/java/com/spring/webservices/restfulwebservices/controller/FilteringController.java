package com.spring.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.webservices.restfulwebservices.bean.AnotherBean;
import com.spring.webservices.restfulwebservices.bean.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering") 
	public List<SomeBean> filteringContent() {
		SomeBean[] arr = {
				new SomeBean("field1", "field2", "field3"), 
				new SomeBean("field1", "field2", "field3"), 
				new SomeBean("field1", "field2", "field3")};
		return Arrays.asList(arr);
	}
	
	@GetMapping("/list-filtering-1")
	public MappingJacksonValue retrievAnotherBeanList1() {
		AnotherBean[] arr = {
				new AnotherBean("field1", "field2", "field3"), 
				new AnotherBean("field1", "field2", "field3"), 
				new AnotherBean("field1", "field2", "field3")};
		
		List<AnotherBean> list = Arrays.asList(arr);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("AnotherBeanFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/list-filtering-2")
	public MappingJacksonValue retrievAnotherBeanList2() {
		AnotherBean[] arr = {
				new AnotherBean("field1", "field2", "field3"), 
				new AnotherBean("field1", "field2", "field3"), 
				new AnotherBean("field1", "field2", "field3")};
		
		List<AnotherBean> list = Arrays.asList(arr);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("AnotherBeanFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
