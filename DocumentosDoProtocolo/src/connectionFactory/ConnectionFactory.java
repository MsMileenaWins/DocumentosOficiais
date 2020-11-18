package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "1402";	
	//DB path, port and DB name
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/documents?autoReconnect=true&useSSL=false";
	
	/*
	 * connection with database
	 */
	public static Connection createConnectionToMYSQL() throws Exception {
		//JVM loads class
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;	
		}
	public static void main(String[] args) throws Exception {
		
			Connection con = createConnectionToMYSQL();
			if(con!=null) {
				System.out.println("connection created");
				con.close();
				}
			

		
	}
}
