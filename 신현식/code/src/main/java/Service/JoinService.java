package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class JoinService {
	
	public List<User> getjoin(String name, String studentID, String password, String department, String email,
			String address, String detailAddress, String motive, String authority) {
		
		List<User> list= new ArrayList<>();
		boolean success = true;
		
		String sql = "INSERT INTO USER(name, studentID, password, department, email, address, detailAddress, motive, authority) VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pst = null;
		int rs;

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
			pst.setString(5, email);
			pst.setString(6, address);
			pst.setString(7, detailAddress);
			pst.setString(8, motive);
			pst.setString(9, authority);
			
			rs = pst.executeUpdate();

			User user = new User (
					name
					,studentID
					,password
					,department
					,email
					,address
					,detailAddress
					,motive
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
