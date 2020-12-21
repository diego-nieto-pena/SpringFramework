package com.dependency.injection.dependencyinjection;

import org.junit.jupiter.api.Test;

import com.dependency.injection.dependencyinjection.injector.BubbleSortInjectorImpl;
import com.dependency.injection.dependencyinjection.injector.InsertionSortInjectorImpl;
import com.dependency.injection.dependencyinjection.injector.SortInjector;

public class DependencyInjectionTest {

	Consumer app; //MYApplication(BubbleService)
	
	SortInjector injector;
	
	@Test
	void testDependencyInjection() {
		//injector = new BubbleSortInjectorImpl();
		injector = new InsertionSortInjectorImpl();
		app = injector.getConsumer();
		app.SearchNumber(null, 2);
	}
}
