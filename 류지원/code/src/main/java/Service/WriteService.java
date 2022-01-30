package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entity.Write;

public class WriteService {
	public List<Write> WriteNotice(String title, String writer, String content) {
		
		List<Write> list= new ArrayList<>();
		
		String sql = "INSERT INTO NOTICE(title, writer, content) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pst = null;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, writer);
			pst.setString(3, content);
			
			
			int rs = pst.executeUpdate();

			Write write = new Write (
					title
					,writer
					,content
					);
			list.add(write);
			

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
	
public List<Write> WriteBoard(String title, String writer, String content) {
		
		List<Write> list= new ArrayList<>();
		
		String sql = "INSERT INTO BOARD(title, writer, content) VALUES (?, ?, ?)";

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
			pst.setString(1, title);
			pst.setString(2, writer);
			pst.setString(3, content);
			
			
			rs = pst.executeUpdate();

			Write write = new Write (
					title
					,writer
					,content
					);
			list.add(write);
			

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
