package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Query2 {

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


			ResultSet rs=stmt.executeQuery("SELECT Vehicle.VehicleID, Vehicle.BranchID, Vehicle.Size FROM Vehicle, Branches WHERE Vehicle.Availability = 'true' and Vehicle.BranchID=Branches.BranchID Group by Vehicle.Size, Vehicle.BranchID, Vehicle.VehicleID");
			while(rs.next()) {

			int id = rs.getInt("VehicleID");
			int branch = rs.getInt("BranchID");
			int size = rs.getInt("Size");

			//Display values
			System.out.print(" " + id);
			System.out.print(", " +branch);
			System.out.println(", " +size);
			}
			conn.close();
			}
			catch(Exception e){
			System.out.println(e);
			}   
	}

}
