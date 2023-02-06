package org.techhub;
import java.sql.*;
import java.util.*;


public class PreparedDeleteapp {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		System.out.println(" Driver Loaded succesfully");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		if(conn!=null) {
			
			Scanner sc= new Scanner(System.in);
			System.out.println("enter the name");
			String n=sc.nextLine();
			
			PreparedStatement stmt=conn.prepareStatement("delete from register where name=? ");
			
			stmt.setString(1, n);
			
			int val = stmt.executeUpdate();
			
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
