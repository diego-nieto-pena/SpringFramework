package com.microservices.limitsservice.bean;

public class ConfigurationLimits {

	private int minimum;
	private int maximum;
	
	protected ConfigurationLimits() {
		
	}
	
	public ConfigurationLimits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}
}