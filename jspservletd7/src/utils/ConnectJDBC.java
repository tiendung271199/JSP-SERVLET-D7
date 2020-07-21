package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {
	private static Connection con = null;
	private static Statement state = null;
	private static ResultSet result;
	
	public static void main(String[] args) {
		try {
			con = JDBCConnectionUtil.getConnection(); // Tạo connection
			// Lấy danh sách các danh mục tin
			final String SQL_Get_All = "SELECT ID_DanhMucTin,TenDanhMucTin FROM danhmuctin";
			// Thực thi truy vấn
			state = con.createStatement();
			result = state.executeQuery(SQL_Get_All);
			while (result.next()) {
				// Lấy dữ liệu trả về từ câu lệnh truy vấn
				int idDanhMucTin = result.getInt("ID_DanhMucTin");
				String tenDanhMucTin = result.getString("TenDanhMucTin");
				System.out.println("ID: " + idDanhMucTin + " - Name: " + tenDanhMucTin);
				System.out.println("==============");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(result, state, con);
		}
		
	}
}
