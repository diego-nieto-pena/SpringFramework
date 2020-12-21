package com.dependency.injection.dependencyinjection;

import com.dependency.injection.dependencyinjection.service.SortService;

public class MyApplication implements Consumer {

	private SortService sortService; //Quick
	
	public MyApplication(SortService sortService) {
		this.sortService = sortService;
	}
	
	@Override
	public void SearchNumber(int[] arr, int x) {
		
		this.sortService.sortArray(arr);
	}

}

//Bubble
//Insertion

//Quick
//Jump
//.......