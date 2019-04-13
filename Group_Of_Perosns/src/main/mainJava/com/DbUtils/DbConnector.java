package com.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnector {
	private static String DBPath  		 = "jdbc:mysql://localhost:3306/Group_Of_Persons";
	private static String USER	  		 = "root";
	private static String PASSWORD	  	 = "pass";
	private static Connection connection = null ;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(DBPath, USER, PASSWORD);
				System.out.println("Db connected succesfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} return connection;
	}
}
