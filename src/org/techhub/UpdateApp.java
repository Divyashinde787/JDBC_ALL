package org.techhub;
import java.util.*;
import java.sql.*;


public class UpdateApp {

	public static void main(String[] args) throws SQLException {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		
		if(conn!=null) {
			Statement stmt= conn.createStatement();
			System.out.println("enter name, email and contact");
			Scanner sc= new Scanner(System.in);
			
			String n=sc.nextLine();
			String e=sc.nextLine();
			String c=sc.nextLine();
						
			int val = stmt.executeUpdate("update register set name='"+n+"', contact='"+c+"' where email='"+e+"'");
			if(val>0) {
				System.out.println("updated");
			}else {
				System.out.println("not updated");
			}
			
		}else {
			System.out.println("not connected");
		}
		

	}

}
