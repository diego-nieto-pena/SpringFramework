package com.principal;

import java.util.List;

public class Dog extends Mammal {

	private List<Procedure> procedureList;

	public Dog(List<Procedure> procedureList) {
		super();
		this.procedureList = procedureList;
	}

	public List<Procedure> getProcedureList() {
		return procedureList;
	}

	public void setProcedureList(List<Procedure> procedureList) {
		this.procedureList = procedureList;
	}

	@Override
	public String toString() {
		return "Dog [procedureList=" + procedureList + "]";
	}
	
	
}
