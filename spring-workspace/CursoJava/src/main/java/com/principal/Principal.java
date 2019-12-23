package com.principal;

import java.io.Serializable;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Animal a1 = new Dog();
		Mammal m1 = new Dog();
		Dog d1 = new Dog();
		
		CommonPoint s1 = new Table();
		CommonPoint s2 = new Dog();
	}

	public void foo(List<CommonPoint> dogTables) {
		for(CommonPoint item: dogTables ) {
			System.out.println(item);
		}
	}
}
