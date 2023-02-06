package org.techhub;

import java.sql.*;
import java.util.*;

public class DeleteApp {

	public static void main(String[] args) throws SQLException {
		//Driver Register
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		System.out.println(" Driver Loaded succesfully");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		if(conn!=null) {
			Statement stmt = conn.createStatement();
			Scanner sc= new Scanner(System.in);
			System.out.println("enter the email");
			String n=sc.nextLine();
			
			int val = stmt.executeUpdate("delete from register where name='"+n+"' ");
			
			if(val>0) {
				System.out.println("record deleted ");
			}
			else {
				System.out.println("some problem");
			}	
	}else {
		System.out.println("not connect");
		
	}
	}
}
