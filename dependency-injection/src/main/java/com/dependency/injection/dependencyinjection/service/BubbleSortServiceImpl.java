package com.dependency.injection.dependencyinjection.service;

public class BubbleSortServiceImpl implements SortService {

	@Override
	public void sortArray(int[] arr) {
		System.out.println("Bubble Sorting");
	}

}
