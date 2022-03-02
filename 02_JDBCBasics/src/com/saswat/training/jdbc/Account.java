package com.saswat.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Account {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
//			System.out.println("connection successful");
			Statement stmt = con.createStatement();
			
//			create or insert -->
//			int result = stmt.executeUpdate("insert into account values(1,'panda','saswat',10000)");
//			int result = stmt.executeUpdate("insert into account values(2,'nayak','raja',1000)");
//			int result = stmt.executeUpdate("insert into account values(3,'nayak','kanha',23000)");
//			System.out.println("successfully inserted :"+result);
			
//			update-->
//			int result = stmt.executeUpdate("update account set bal=40000 where accno=1");
//			System.out.println("successfully updated :"+result);
			
//			delete-->
//			int result = stmt.executeUpdate("delete from account where accno=3");
//			System.out.println("successfully deleted :"+result);
			
//			read-->
			ResultSet rs = stmt.executeQuery("select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString(2)+" "+rs.getInt(4));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
