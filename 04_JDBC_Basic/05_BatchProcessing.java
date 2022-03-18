package jdbc;

import java.sql.*;

class BatchProcessing {
	public static void main(String args[]) {
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			stmt = con.createStatement();
			
			stmt.addBatch("insert into account values(200,'nayak','abhi',40000)");  
			stmt.addBatch("insert into account values(201,'panda','umesh',50000)");  
			  
			int result[] = stmt.executeBatch();//executing the batch
			
			for(int val : result) {
				System.out.println(val);
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
