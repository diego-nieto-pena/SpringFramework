package com.demo.basics.DemoBasics.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness {

	@Inject
	SomeCdiDao someCdiDao;

	public SomeCdiDao getSomeCdiDao() {
		return someCdiDao;
	}

	public void setSomeCdiDao(SomeCdiDao someCdiDao) {
		this.someCdiDao = someCdiDao;
	}
	
	public int getLargetNumber() {
		int[] data = someCdiDao.getData();
		int largest = Integer.MIN_VALUE;
		
		for(int i : data) {
			if(i > largest) {
				largest = i;
			}
		}
		
		return largest;
	}
}
