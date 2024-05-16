package com.bb.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.bb.Dao.IConnection.*;
public class DBConnection 
{
	private DBConnection()
	{
		// private constructor
	}
	
	public static Connection getConnection() 
	{
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(url,username,password);
				
		} catch (Exception e) 
		{
		      e.getMessage();
		}
		
		return con;
	}
	
	
	

}
