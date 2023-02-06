package org.techhub;

import java.sql.*;
import java.util.*;

public class PreparedUpdateApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		if(conn!= null) {
			
			System.out.println("enter name, email and contact");
			Scanner sc = new Scanner(System.in);
			String name=sc.nextLine();
			String contact=sc.nextLine();
			String email=sc.nextLine();
			
			PreparedStatement stmt = conn.prepareStatement("update register set name=?, contact=? where email=?");
			
			stmt.setString(1, name);
			stmt.setString(2, contact);
			stmt.setString(3, email);
			
			
			int val = stmt.executeUpdate();
			if(val>0) {
				System.out.println("updated success......");
			}
			else {
				System.out.println("not updated.......");
			}
		}else {
			System.out.println("not connect.......");
		}
		

	}

}
