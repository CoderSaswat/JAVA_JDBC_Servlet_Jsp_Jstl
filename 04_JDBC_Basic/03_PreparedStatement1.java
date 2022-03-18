package jdbc;

import java.sql.*;

class PreparedStatement1 {
	public static void main(String args[]) {
		Connection con;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			ps = con.prepareStatement("insert into account values(?,?,?,?)");
			
			ps.setInt(1, 101);// 1 specifies the first parameter in the query
			ps.setString(2, "raina");
			ps.setString(3, "samay");
			ps.setInt(4, 44444);

			int i = ps.executeUpdate();
			System.out.println(i + " records inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}