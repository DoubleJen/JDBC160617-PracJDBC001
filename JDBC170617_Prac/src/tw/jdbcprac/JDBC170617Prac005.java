package tw.jdbcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC170617Prac005 {

	public static void main(String[] args) {
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:5678;" +
//							   "user=sa;password=6315;" +
//							   "databaseName=Northwind;";
		
		String connectionUrl ="jdbc:sqlserver://localhost\\SQLEXPRESS;database=Northwind;user=sa;password=6315";
		
		//2.Build Connection
		try {
			Connection conn = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection OK!");
			
		//3.SQL Statement	
			Statement stmt = conn.createStatement();
		
		//4.Query	
			ResultSet rs = stmt.executeQuery("select * from Products");
			while(rs.next()){
				String pname = rs.getString("ProductName");
				System.out.println(pname);
			}
			
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		

	}

}
