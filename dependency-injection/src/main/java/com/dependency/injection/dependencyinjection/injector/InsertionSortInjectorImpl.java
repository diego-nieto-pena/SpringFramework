package com.dependency.injection.dependencyinjection.injector;

import com.dependency.injection.dependencyinjection.Consumer;
import com.dependency.injection.dependencyinjection.MyApplication;
import com.dependency.injection.dependencyinjection.service.InsertionSortServiceImpl;

public class InsertionSortInjectorImpl implements SortInjector {

	@Override
	public Consumer getConsumer() {
		return new MyApplication(new InsertionSortServiceImpl());
	}

}
