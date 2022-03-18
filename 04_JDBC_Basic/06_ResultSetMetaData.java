package jdbc;

import java.sql.*;

class ResultSetMetaData {
	public static void main(String args[]) {
		Connection con;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			ps = con.prepareStatement("select * from account");
			ResultSet rs = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total columns: " + rsmd.getColumnCount());
			System.out.println("Column Name of 1st column: " + rsmd.getColumnName(3));
			System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}