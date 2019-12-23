package com.unittesting.unittesting;

public enum Paises {

	COLOMBIA("Colombia", "Bogota"),
	PERU("Peru", "Lima"),
	BRASIL("Brasil", "Brasilia"),
	USA("USA", "guasinton");
	
	private final String pais;
	private final String capital;
	
	private Paises(String pais, String capital) {
		this.pais = pais;
		this.capital = capital;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public String getCapital() {
		return this.capital;
	}
}
