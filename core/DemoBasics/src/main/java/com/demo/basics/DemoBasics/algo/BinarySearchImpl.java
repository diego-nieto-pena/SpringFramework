package com.demo.basics.DemoBasics.algo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.basics.DemoBasics.util.Util;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//PROTOTYPE --> new BinarySearchImpl
public class BinarySearchImpl {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	//@Qualifier("bubble")
	private SortAlgorithm sortAlgorithm;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("PostConstruct ;)");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("PreDestroy");
	}
	
	public int searchNumber(int[] arr, int number) {
		int mid = -1;
		
		this.sortAlgorithm.sort(arr);
		
		Util.printArr(arr);
		
		int n = arr.length;
		int l=0, r= n-1;
		
		while(r >= l) {
			mid = l + (r - l) / 2;
			
			if(arr[mid] == number)
				return mid;
			if(arr[mid] > number)
				r = mid-1;
			if(arr[mid] < number)
				l = mid + 1;
		}
		System.out.println("INDEX: " + mid);
		return mid;
	}
}

