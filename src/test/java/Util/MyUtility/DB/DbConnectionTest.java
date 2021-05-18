package Util.MyUtility.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DbConnectionTest {
	
	@Test
	public void connectMysqlDB(){
String host ="localhost";
String port ="3306";
String dbName = "udemyLearning";

		try {
			Connection con=DriverManager.getConnection(  "jdbc:mysql://"+host+":"+port+"/"+dbName ,"root","root");
			//Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/world","root","root");
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Employeeinfo  where name = 'mayank'");
			while(rs.next()){
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getInt("age"));				
			}
	
					
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
