package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();

	}

	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/project";
			String username = "root";
			String password = "Sindhu1@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			return conn;
			
		}catch(Exception e){System.out.println(e);}
		
		
		return null;
}
}
