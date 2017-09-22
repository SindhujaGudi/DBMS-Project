package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class CarCompanyQuery {

	public static void main(String[] args)throws Exception 
	{
		// TODO Auto-generated method stub
		getConnection();
	}
		public static Connection getConnection() throws Exception
		{
			try
			{
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/project";
				String username = "root";
				String password = "Sindhu1@";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url, username, password);
				
				Statement stmt=conn.createStatement();


				ResultSet rs=stmt.executeQuery("select * from Vehicle group by VehicleID, TypeDescription, HomeBranch");
				while(rs.next()) 
				{

				int id = rs.getInt("VehicleID");
				String branch = rs.getString("HomeBranch");
				String type= rs.getString("TypeDescription");

				//Display values
				System.out.print(" " + id);
				System.out.print(", " +branch);
				System.out.println(", " +type);

				}
				conn.close();
				
		
				
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
			
			
			
			return null;
	}

}
