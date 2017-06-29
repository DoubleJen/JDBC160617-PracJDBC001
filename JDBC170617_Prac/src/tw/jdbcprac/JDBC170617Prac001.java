package tw.jdbcprac;
//Connection conn = DriverManager.getConnection(String url)
//boolean vs execute
//Some Wording Fr http://web.nchu.edu.tw/~jlu/cyut/mysql-jdbc.shtml 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC170617Prac001 {

	public static void main(String[] args) {
		//1.Driver
		//利用 Class.forName(驅動程式的名稱); 載入 JDBC 的驅動程式；
		//以 MySQL 的 JDBC 驅動程式的名稱為例，載入的用法為 Class.forName("com.mysql.jdbc.Driver");。
		//每一種驅動程式都有其相對應的名稱，開發人員在使用之前必須先搞清楚。
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK!");
		} catch (ClassNotFoundException De) {
			System.out.println(De);
			System.exit(0);
		}
		
		//2.Build Connection
		//利用 Connection conn = DriverManager.getConnection(資料庫的位置, 帳號名稱, 密碼); 
		//來產生一個 Java 程式和資料庫之間的連線（也就是 Connection 物件 conn）。 
		//DriverManager.getConnection() 內有三個參數，第一個參數說明程式想要跟哪一個資料庫連線；
		//同樣的，這個參數的值會因為使用的 JDBC驅動程式不同而不同，
		//以我們的範例為例，因為我們使用 MySQL 的 JDBC 驅動程式，而且因為 MySQL 的位置在本機（也就是 127.0.0.1），且因為資料庫的名稱為 "eric"， 
		//所以第一個參數值必須為 "jdbc:mysql://127.0.0.1/eric"（其中 jdbc:mysql: 是固定不變的，
		//最後 "//IP 位址/資料庫名稱" 會隨著 MySQL 安裝的 IP 位址以及該 MySQL 上的資料庫名稱的不同而改變）。
		//第二個以及 第三個參數分別為連結該資料庫所需要的"帳號名稱"以及"密碼"。
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/doubleprac?"
															+"user=root&password=root");
			System.out.println("Connection OK!");
			
		//3.SQL Statement
		//連線完成之後，可以開始執行 SQL 的指令了。
		//執行 SQL 指令的方式是先藉由conn產生一個 Statement 的物件，然後再藉由 Statement 的物件來執行 SQL 指令。
		//產生 Statement 物件的方式 為 Statement stmt = conn.createStatement();，
		//其中stmt 即為 Statement 物件的名稱。
			Statement stmt = conn.createStatement();
		
		//4.Query	
			String sql = "insert into cust(cname, tel, birthday) values('Tony','0932','1985-01-12')";
			boolean isQueryOK = stmt.execute(sql);
			System.out.println(isQueryOK);
			if(isQueryOK){System.out.println("Query OK!");}
			else{System.out.println("Query OK Too");}
			
		} catch (SQLException Conne) {
			System.out.println(Conne);
		}
		

	}

}
