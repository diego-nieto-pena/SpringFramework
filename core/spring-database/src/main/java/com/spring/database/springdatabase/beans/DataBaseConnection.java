package com.spring.database.springdatabase.beans;

public interface DataBaseConnection {

	void print();
	
	public JdbcConnection getJdbcConnection();
}
