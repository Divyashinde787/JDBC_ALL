package org.techhub;

import java.sql.*;
import java.util.*;

public class PreParedStmt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		
		if(conn!=null) {
			System.out.println("enter name, email and contact");
			Scanner sc= new Scanner(System.in);
			
			String name=sc.nextLine();
			String email=sc.nextLine();
			String contact=sc.nextLine();
			
			PreparedStatement stmt = conn.prepareStatement("insert into register values(?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, email);
			stmt.setString(3,contact);
			
			int val=stmt.executeUpdate();
			
			if(val>0) {
				System.out.println("save sucess");
			}else {
				System.out.println("some problem...");
			}
		}else {
			System.out.println("not connected");
	}

	}}
