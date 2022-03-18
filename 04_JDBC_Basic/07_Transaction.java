package jdbc;

import java.sql.*;

class Transaction {
	public static void main(String args[]) {
		Connection con = null;
		Statement stmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			stmt = con.createStatement();
			
			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal = bal - 1000 where firstname = 'umesh'");
			stmt.executeUpdate("update account set bal = bal + 1000 where firstname = 'abhi'");
			con.commit();
			
			con.close();
		} catch (Exception e) {
			try {
				con.close();
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
