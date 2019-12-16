package com.demo.basics.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

	@Value("${external.url.service}")
	private String url;
	
	public String returnServiceUrl() {
		return this.url;
	}
}
