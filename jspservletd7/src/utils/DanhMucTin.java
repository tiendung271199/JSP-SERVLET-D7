package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DanhMucTin {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/tintuc?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";

	private static Connection con = null;
	private static Statement state = null;
	private static ResultSet result;

	public static void main(String[] args) {
		try {
			Class.forName(driver); // Nạp driver
			con = DriverManager.getConnection(url, user, password); // Tạo connection
			System.out.println("Successfully connected to database");
			final String SQL_Get_ID = "SELECT ID_DanhMucTin,TenDanhMucTin FROM danhmuctin WHERE ID_DanhMucTin=3";
			state = con.createStatement();
			result = state.executeQuery(SQL_Get_ID);
			if (result.next()) {
				int idDanhMucTin = result.getInt("ID_DanhMucTin");
				String tenDanhMucTin = result.getString("TenDanhMucTin");
				System.out.println("ID: " + idDanhMucTin + " - Name: " + tenDanhMucTin);
			}
			if (!con.isClosed()) {
				con.close();
				System.out.println("Database closed successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
