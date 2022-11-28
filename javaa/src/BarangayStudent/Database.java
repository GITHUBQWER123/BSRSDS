package BarangayStudent;

import java.sql.*;
import javax.swing.*;


public class Database {

	public static void main(String[] args ) {
		Connection conn;
		
		 try
		{
			 	Class.forName("com.mysql.cj.jdbc.Driver");
			 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
				if(conn!=null) {
					System.out.println("Connected");
				}
					
			
		}
		catch (Exception e)	
		{
			System.out.println("Not Connected");
		
		}
}	
		
}