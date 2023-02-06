package org.techhub;

import java.sql.*;
import java.util.*;

public class UserValidation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		if(conn!=null) {
			System.out.println("enter username and password");
			Scanner sc= new Scanner(System.in);
			String username=sc.nextLine();
			String password=sc.nextLine();
			
			PreparedStatement stmt= conn.prepareStatement("select * from login where username=? and password=?");
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("valid password and username");
			}
			else {
				System.out.println("invalid username and password");
			}
		}else {
			System.out.println("not connected");
		}
	}

}
