package com.dependency.injection.dependencyinjection.injector;

import com.dependency.injection.dependencyinjection.Consumer;
import com.dependency.injection.dependencyinjection.MyApplication;
import com.dependency.injection.dependencyinjection.service.BubbleSortServiceImpl;

public class BubbleSortInjectorImpl implements SortInjector{

	@Override
	public Consumer getConsumer() {
		return new MyApplication(new BubbleSortServiceImpl());
	}

}
