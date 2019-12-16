package com.demo.basics.DemoBasics.cdi;

import javax.inject.Named;

@Named
public class SomeCdiDao {
	public SomeCdiDao() {
		System.out.println("SomeCdiDao");
	}
	
	public int[] getData() {
		return new int[] {1,4,8,1,66,77,666};
	}
}
