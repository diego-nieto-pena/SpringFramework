package com.dependency.injection.dependencyinjection;

import org.junit.jupiter.api.Test;

import com.dependency.injection.dependencyinjection.injector.BubbleSortInjectorImpl;
import com.dependency.injection.dependencyinjection.injector.SortInjector;

public class DependencyInjectionTest {

	Consumer app;
	
	SortInjector injector;
	
	@Test
	void testDependencyInjection() {
		injector = new BubbleSortInjectorImpl();
		app = injector.getConsumer();
		app.SearchNumber(null, 2);
	}
}
