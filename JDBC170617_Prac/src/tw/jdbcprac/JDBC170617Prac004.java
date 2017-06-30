package tw.jdbcprac;
//Microsoft SQL Server JDBC 驅動程式 建立連至 SQL Server 的簡單連接

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC170617Prac004 {

	public static void main(String[] args) {
		//1.Driver
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver OK!");
		} catch (ClassNotFoundException De) {
			System.out.println(De);
			System.exit(0);
		}
		
		//2.Build Connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/doubleprac?"
															+"user=root&password=root");
			System.out.println("Connection OK!");
			
		//3.SQL Statement
			Statement stmt = conn.createStatement();
		
		//4.Query	
			String sql = "insert into cust(cname, tel, birthday) values('Frank','0911','1980-08-01')";
			boolean isQueryOK = stmt.execute(sql);
			System.out.println(isQueryOK);
			if(isQueryOK){System.out.println("Query OK!");}
			else{System.out.println("Query OK Too");}
			
		} catch (SQLException Conne) {
			System.out.println(Conne);
		}
		

	}

}
