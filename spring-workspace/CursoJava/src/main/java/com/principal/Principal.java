package com.principal;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		List<Procedure> pList = new ArrayList<>();
		
		Procedure p1 = new Procedure(15000, 0, 0);
		Procedure p2 = new Procedure(0, 0, 70000);
		Procedure p3 = new Procedure(0, 10000, 0);
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
	
		
		Dog nala = new Dog(pList);
		
		System.out.println(nala);
		
		int total = sum(pList);
		
		System.out.println("Total Value: " + total);
	}
	
	private static int sum(List<Procedure> pList) {
		int total = 0;
		
		for(Procedure p : pList) {
			total += p.getCastration() + p.getShower() + p.getVaccine();
		}
		
		return total;
	}
	
}
