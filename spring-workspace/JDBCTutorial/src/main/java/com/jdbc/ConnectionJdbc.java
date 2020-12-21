package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//API --> JavaDataBaseConnection

public class ConnectionJdbc {

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial", "root", "admin");
			
			PreparedStatement pst = conn.prepareStatement("select * from course");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_course");
				String courseName = rs.getString(1);
				int studentNum = rs.getInt("students_num");
				int idTeacher = rs.getInt(4);
				
				System.out.println("ID: " + id);
				System.out.println("Course Name: " + courseName);
				System.out.println("Student Number: " + studentNum);
				System.out.println("ID Teacher: " + idTeacher);
				System.out.println("***************************************");
			}
			
			
			System.out.println("Connection succesful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
//Checked SQLException