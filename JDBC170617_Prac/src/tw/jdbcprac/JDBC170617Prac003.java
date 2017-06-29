package tw.jdbcprac;
//Connection conn = DriverManager.getConnection(String url, Properties info)
//Resultset vs executeQuery
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC170617Prac003 {

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
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/doubleprac", prop);
			System.out.println("Connection OK!");
			
		//3.SQL Statement
			Statement stmt = conn.createStatement();
		
		//4.Query	
			String sql = "select * from cust";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()){
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.println(id + " : " + cname + " : " + 
								   " : " + tel + " : " +birthday);
				
			}
			
		} catch (SQLException Conne) {
			System.out.println(Conne);
		}
		

	}

}
