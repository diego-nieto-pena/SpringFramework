package com.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.springaop.annotation.TrackTime;
import com.aop.springaop.dao.DataDao1;

@Service
public class Business1 {
	
	@Autowired
	DataDao1 dataDao1;
	
	@TrackTime
	public String doSomeBusiness() {
		return dataDao1.retrieveData();
	}
	
	public void throwException() throws Exception {
		throw new Exception("Just throwing an exception to be logged");
	}
}
