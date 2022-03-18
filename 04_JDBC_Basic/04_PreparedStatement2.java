package jdbc;

import java.sql.*;

class PreparedStatement2 {
	public static void main(String args[]) {
		Connection con;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			ps = con.prepareStatement("select * from account");			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "+ rs.getInt(4));				
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}