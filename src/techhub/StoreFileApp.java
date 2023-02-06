package techhub;

import java.sql.*;
import java.io.*;

public class StoreFileApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		
		if(conn!=null) {
			
			File f= new File("C:\\Users\\Suraj Enterpries\\Documents\\NewText.txt");
			FileReader fr = new FileReader(f);
			
			PreparedStatement stmt = conn.prepareStatement("insert into storefile values('0',?,?)");
			
			stmt.setString(1, "this line stored from jdbc \n");
			int l=(int)f.length();
			stmt.setCharacterStream(2, fr,l);    
			
			int value=stmt.executeUpdate();
			if(value>0) {
				System.out.println("save ..........");
			}else {
				System.out.println("fail..........");
			}
		}else {
			System.out.println("not connected");
		}
			
	}

}
