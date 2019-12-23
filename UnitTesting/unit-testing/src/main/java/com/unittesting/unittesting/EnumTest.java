package com.unittesting.unittesting;

public class EnumTest {

	public static void main(String[] args) {
		Paises co = Paises.COLOMBIA;
		Paises pe = Paises.PERU;
		
		System.out.println(co.getPais() +  "-" + co.getCapital());
		System.out.println(pe.getPais());
	}
}
