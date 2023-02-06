package techhub;

import java.sql.*;
import java.sql.DriverManager;
//count number of column in DB Table: : ResultSetMetaData
// return column name and type 
public class MetaStmtApp {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root",null);
		
		if(conn!=null) {
			
			PreparedStatement stmt = conn.prepareStatement("select * from register");
			ResultSet rs= stmt.executeQuery();
			
			ResultSetMetaData mt= rs.getMetaData();
			int ncol=mt.getColumnCount();
			System.out.println("Numbers of column in database table is"+ncol);
			
			for(int i=1; i<=ncol; i++) {
				System.out.println(mt.getColumnName(i)+"\t"+mt.getColumnTypeName(i)+"\t"+mt.getColumnDisplaySize(i));
			}
			}else {
				System.out.println("not connected");
			}
	}
}
