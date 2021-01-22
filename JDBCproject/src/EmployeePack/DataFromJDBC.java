package EmployeePack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataFromJDBC {

	String url = "jdbc:mysql://localhost:3306/mukta";//jdbc.sqlserver://DESKTOP-3LAS9CR\\SQLEXPRESS
	String driver = "com.mysql.jdbc.Driver";//com.microsoft.sqlserver.jdbc.SQLServerDriver
	String mssqlstmt = "select username, password from userdata";
	String username = "root";
	String password = "root";
	Connection con = null;
	Statement stm = null;
	ResultSet rs = null;
	Map<String, String> data = null;

	public Map<String, String> dataretrivefromemployeetable() throws SQLException, ClassNotFoundException {
		//jdbc driver load for sql server
		Class.forName(driver);
		
		//Connection with database
		con = DriverManager.getConnection(url,username,password);
		
		//create statment 		
		stm = con.createStatement();
		
		//execution of sql query and save resultset
		rs = stm.executeQuery(mssqlstmt);
		
		//initialize map object that would be returned
		data = new HashMap<>();

		while (rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			data.put(username, password);
		}
		
		//resultset closing
		rs.close();
		//statement closing
		stm.close();
		//closing connection
		con.close();
		
/*		data.put("parveen1", "123");
		data.put("parveen2", "123");
		data.put("parveen3", "123");
*/		
		return data;
	}
	

}
