package com.steps.mockito.mockito5steps;

public class SomeBusiness {

	private DataService dataService;
	
	public SomeBusiness(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int getTheGreatest() {
		int[] arr = dataService.retrieveAllData();
		
		int greatest = Integer.MIN_VALUE;
		
		for(int item : arr) {
			if(item > greatest) {
				greatest = item;
			}
		}
		
		return greatest;
	}
}
