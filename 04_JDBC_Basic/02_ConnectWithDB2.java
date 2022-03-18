package jdbc;

import java.sql.*;

class ConnectWithDB2 {
	public static void main(String args[]) {
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			stmt = con.createStatement();
			int result = stmt.executeUpdate("update account set bal = 99999 where firstname='saswat' ");
			System.out.println("rows updated : " + result);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
