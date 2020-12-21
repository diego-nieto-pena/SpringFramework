package com.player.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author diego.nieto
 * Properties loader
 */
public class PropertiesLoader {

	private InputStream inputStream;
	Properties props;
	
	public PropertiesLoader() {
		
		props = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		
		if(inputStream != null) {
			try {
				props.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
