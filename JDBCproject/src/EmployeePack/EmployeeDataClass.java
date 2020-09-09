package EmployeePack;

import java.sql.*;

import javax.swing.JOptionPane;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeDataClass {
	String ServerName="jdbc.sqlserver://DESKTOP-3LAS9CR\\SQLEXPRESS";
	String login="sa";
	String password="1234";
	String database="SuperTech";
	String ConnectionURL=ServerName+login+password;
	@BeforeTest
	public void serverconnection() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		JOptionPane.showMessageDialog(null, "connected to SQLServer");
	}
	@Test
	public void dataretrivefromemployeetable() throws SQLException {
		String mssqlstmt="select EMPLOYEE_ID,FIRST_NAME,LAST_NAME from Employees";
		Connection con=DriverManager.getConnection(ConnectionURL);
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(mssqlstmt);
		
		while (rs.next()) {
			System.out.println(rs.getString("EMPLOYEE_ID")+rs.getString("FIRST_NAME")+
					rs.getString("LAST_NAME")+rs.getString("EMAIL")+
					rs.getString("PHONE_NUMBER")+rs.getString("HIRE_DATE"));
		}
		con.close();//database connection disconnected
		
		
				
	}
	
	

}
