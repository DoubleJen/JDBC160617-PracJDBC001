package tw.jdbcprac;
//Connection conn = DriverManager.getConnection(String url, String user, String password)
//boolean vs execute
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC170617Prac002 {

	public static void main(String[] args) {
		//1.Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK!");
		} catch (ClassNotFoundException De) {
			System.out.println(De);
			System.exit(-1);
		}
		
		//2.Build Connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/doubleprac", "root", "root");
			System.out.println("Connection OK!");
			
		//3.SQL Statement
			Statement stmt = conn.createStatement();
		
		//4.Query	
			String sql = "update cust set cname='Double', tel='0963', birthday='1985-01-01' where id=2";
			boolean isQueryOK = stmt.execute(sql);
			System.out.println(isQueryOK);
			if(isQueryOK){System.out.println("Query OK!");}
			else{System.out.println("Query OK Too");}
			
		} catch (SQLException Conne) {
			System.out.println(Conne);
		}
		

	}

}
