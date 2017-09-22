package database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		System.out.println("JUnit Testing with Database");
		Connection conn = null;
		
		String q = "select VehicleID from Vehicle where TypeDescription = 'Midsized' and RegistrationNumber = any (SELECT RegistrationNumber from Vehicle, Branches where Vehicle.Availability = 'true' and Vehicle.BranchID = Branches.BranchID) ";
		
		int VechileID[] = { 111, 112};
		
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/project";
			String username = "root";
			String password = "Sindhu1@";
			Class.forName(driver);
			
			ResultSet res = null;
			java.sql.ResultSetMetaData rsmd = null;
			
			rsmd = res.getMetaData();
			
			int x = rsmd.getColumnCount();
			System.out.println();
			System.out.println();
			
			int y = 0;
			while(res.next())
			{
				for(int a=1; a<=x; a++)
					assertEqals(res.getString(a),VechileID[y++]);
				System.out.println();
				
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

	private void assertEqals(String string, int i) {
		// TODO Auto-generated method stub
		fail("invalid input");
	}

}
