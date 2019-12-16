package com.demo.basics.DemoBasics.algo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSort implements SortAlgorithm {

	@Override
	public void sort(int[] arr) {
		System.out.println("***Bubble Sort***");
		
		int n = arr.length;
		
		for(int i=0; i < n-1; i++) {
			for(int j=0; j < n-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		
	}

}
