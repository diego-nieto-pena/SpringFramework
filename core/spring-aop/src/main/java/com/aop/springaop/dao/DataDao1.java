package com.aop.springaop.dao;

import org.springframework.stereotype.Repository;

import com.aop.springaop.annotation.TrackTime;

@Repository
public class DataDao1 {

	@TrackTime
	public String retrieveData() {
		return "DataDao1";
	}
}
