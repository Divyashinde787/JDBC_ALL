package techhub;

import java.sql.*;

public class CallStmtApp {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		
		if(conn!=null) {
			
			CallableStatement cstmt = conn.prepareCall("{call saverecord(?,?,?)}");
			cstmt.setString(1, "ram");
			cstmt.setString(2,"ramm@gmail.com");
			cstmt.setString(3, "123488");
			
			Boolean b =cstmt.execute();
			if(!b) {
		
				System.out.println("execute sucessfully");
			}else {
				System.out.println("not execute ........");
			}
		}else {
			System.out.println("not connected.....");
		}

	}

}
