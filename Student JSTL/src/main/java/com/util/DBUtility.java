package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	public Connection getDBConnection(String url, String username, String password) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("URL GETTING "+url);
			System.out.println("USERNAME GETTING "+username);
			System.out.println("PASSWORD GETTING "+password);
			con = DriverManager.getConnection(url, username,password);
		} catch (Exception e) {
			System.out.println("====>  "+e);
		}

		return con;

	}

}
