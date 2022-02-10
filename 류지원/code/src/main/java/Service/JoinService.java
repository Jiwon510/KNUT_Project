package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class JoinService {
	
	public List<User> getjoin(String name, String studentID, String password, String department, String birth,
			String gender, String email, String phone, String address, String detailaddress, String authority) {
		
		List<User> list= new ArrayList<>();
		boolean success = true;
		
		String sql = "INSERT INTO userTBL(name, studentID, password, department, birth, gender, email, "
				+ "phone, address, detailaddress, authority) "
				+ "VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, studentID);
			pst.setString(3, password);
			pst.setString(4, department);
			pst.setString(5, birth);
			pst.setString(6, gender);
			pst.setString(7, email);
			pst.setString(8, phone);
			pst.setString(9, address);
			pst.setString(10, detailaddress);
			pst.setString(11, authority);
			
			rs = pst.executeUpdate();

			User user = new User (
					name
					,studentID
					,password
					,department
					,birth
					,gender
					,email
					,phone
					,address
					,detailaddress
					,authority
					);
			list.add(user);
			
			

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return list;
	}
}
