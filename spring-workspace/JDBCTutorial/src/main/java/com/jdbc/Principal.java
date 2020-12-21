package com.jdbc;

public class Principal {

	public static void main(String[] args) {
		ConnectionJdbc conn = new ConnectionJdbc();
		conn.getConnection();
	}

}
