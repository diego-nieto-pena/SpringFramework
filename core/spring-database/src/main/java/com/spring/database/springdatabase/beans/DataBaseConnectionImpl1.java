package com.spring.database.springdatabase.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mysql")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataBaseConnectionImpl1 implements DataBaseConnection {

	@Autowired
	private JdbcConnection jdbcConnection;
	
	@Override
	public void print() {
		System.out.println("***********************************************************");
		System.out.println("MySQL");
		System.out.println("***********************************************************");
	}

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	
}
