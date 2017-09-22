package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Query1 {

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


			ResultSet rs=stmt.executeQuery("SELECT VehicleID, Branches.BranchID, TypeDescription FROM Vehicle, Branches WHERE Branches.BranchID= 22 and Vehicle.BranchID=Branches.BranchID and Vehicle.TypeDescription='Compact' and Vehicle.Availability='true'");
			while(rs.next()) {

			int id = rs.getInt("VehicleID");
			String branch = rs.getString("BranchID");
			String type = rs.getString("TypeDescription");

			//Display values
			System.out.print(" " + id);
			System.out.print(", " +branch);
			System.out.print(", " +type);
			}
			conn.close();
			}
			catch(Exception e){
			System.out.println(e);
			}   
	}

}
