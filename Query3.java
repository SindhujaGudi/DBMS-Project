package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Query3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/project";
			String username = "root";
			String password = "Sindhu1@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);

			Statement stmt=conn.createStatement();


			ResultSet rs=stmt.executeQuery("SELECT C.CustomerID, B.BookingDate FROM Customer C, BookingDetails B WHERE C.CustomerID = B.CustomerID and C.CustomerID = 1 and B.BookingDate<CURDATE()");
			while(rs.next()) {

			int id = rs.getInt("CustomerID");
			String Bookingdate = rs.getString("BookingDate");
			

			//Display values
			System.out.print(" " + id);
			System.out.println(", " +Bookingdate);
			}
			conn.close();
			}
			catch(Exception e){
			System.out.println(e);
			}   
	}

}
