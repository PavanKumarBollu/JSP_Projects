package com.pavan.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUitls {
	private JDBCUitls()
	{
		// to prevent Object Creation
	}
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DriverLoaded SuccessFully....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() throws IOException, SQLException
	{
		
		FileInputStream file = new FileInputStream("D:\\FullStack_Development\\5_Code__Projects\\2_BackEnd\\5_JSP\\MVC_CRUD_APP_JDBC_SERVLET_JSP_JSTL\\src\\main\\java\\com\\pavan\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(file);
		String url = properties.getProperty("url");
		String uName = properties.getProperty("uName");
		String uPassword = properties.getProperty("uPassword");
		return DriverManager.getConnection(url, uName, uPassword);
	}
}
