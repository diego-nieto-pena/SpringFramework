package com.unittesting.unittesting.business;

import com.unittesting.unittesting.repository.DataService;

public class CountingService {

	private DataService service;
	
	public int sumNumbers() {

		int total = 0;
		
		int[] array = service.getData();
		
		for(int i : array) {
			total += i;
		}
		
		return total;
	}

	public int sumNNumbers(int n) {

		int total = 0;
		
		for(int i=1; i <= n; i++) {
			total += i;
		}
		
		return total;
	}
	
	public DataService getService() {
		return service;
	}

	public void setService(DataService service) {
		this.service = service;
	}
}
