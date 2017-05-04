package model;

import java.sql.*;
public class DBUtils {
	
	public static Connection getConnection(String driver,String url,String user_name,String pass) throws SQLException, ClassNotFoundException
	{   
		Class.forName(driver);
		return DriverManager.getConnection(url,user_name,pass);
	}

}
