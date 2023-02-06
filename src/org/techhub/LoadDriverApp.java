package org.techhub;
import java.sql.*;
import java.util.*;
//import java.io.SQLException;
//4
public class LoadDriverApp {

	public static void main(String[] args) throws SQLException {
		//Driver Register
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		System.out.println(" Driver Loaded succesfully");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		if(conn!=null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter name, email, contact");
			String name= sc.nextLine();
			String email= sc.nextLine();
			String contact= sc.nextLine();
			
			Statement stmt = conn.createStatement();
			int val = stmt.executeUpdate("insert into register values('"+name+"','"+email+"','"+contact+"')");
			
		//	int val = stmt.executeUpdate("insert into register values('divyas','divyashinde@gmail.com','1234567')");
			if(val>0) {
			System.out.println("record save sucessfully......");
		}
		else {
			System.out.println("same problem is there......");
			}
		}
		
		else{
			System.out.println("not connected");	
		}
	}
}
/*
if(conn!=null) {
	
	Statement stmt = conn.createStatement();
	int val = stmt.executeUpdate("insert into register values('divyas','divyashinde@gmail.com','1234567')");
*/	
