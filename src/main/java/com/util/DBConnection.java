package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static final String url = "jdbc:mysql://localhost:3306/companydb";
		static final String username = "root";
		static final String password = "root";
		
		static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			throw new RuntimeException("Database driver not found " + e);
		}
		}
		
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(url,username,password);
		}
}

