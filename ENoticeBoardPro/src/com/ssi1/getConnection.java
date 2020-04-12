package com.ssi1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
	
	public static Connection connect()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/notice","root","root");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	     
	     return conn;
	}

}
