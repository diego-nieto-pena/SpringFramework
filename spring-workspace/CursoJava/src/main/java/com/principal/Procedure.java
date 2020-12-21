package com.principal;

public class Procedure {

	private int shower;
	private int vaccine;
	private int castration;

	public Procedure(int shower, int vaccine, int castration) {
		super();
		this.shower = shower;
		this.vaccine = vaccine;
		this.castration = castration;
	}

	public int getVaccine() {
		return vaccine;
	}

	public void setVaccine(int vaccine) {
		this.vaccine = vaccine;
	}

	public int getCastration() {
		return castration;
	}

	public void setCastration(int castration) {
		this.castration = castration;
	}

	public int getShower() {
		return shower;
	}

	public void setShower(int shower) {
		this.shower = shower;
	}

	@Override
	public String toString() {
		return "Procedure [shower=" + shower + ", vaccine=" + vaccine + ", castration=" + castration + "]";
	}
	
	
}
