package com.demo.basics.DemoBasics.algo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Qualifier("selection")
@Primary
public class SelectionSort implements SortAlgorithm {

	@Override
	public void sort(int[] arr) {
		System.out.println("***Selection Sort***");
		int n = arr.length;
		
		for(int i=0; i < n-1; i++) {
			int min_id = i;
			for(int j=i+1; j< n; j++) {
				if(arr[j] < arr[min_id]) {
					min_id = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_id];
			arr[min_id] = temp;
		}
	}

}
