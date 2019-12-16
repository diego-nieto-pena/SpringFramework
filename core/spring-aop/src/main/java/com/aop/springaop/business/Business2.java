package com.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.springaop.dao.DataDao2;

@Service
public class Business2 {
	
	@Autowired
	DataDao2 dataDao2;
	
	public String doSomeBusiness() {
		return dataDao2.retrieveData();
	}
}
