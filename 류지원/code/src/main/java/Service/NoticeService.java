package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Notice;

public class NoticeService {

	public List<Notice> getNoticeList() {

		return getNoticeList("title", "", 1);
	}

	public List<Notice> getNoticeList(int page) {

		return getNoticeList("title", "", page);
	}
	
	/* notice */
	public List<Notice> getNoticeList(String field, String query, int page) {

		List<Notice> list = new ArrayList<>();

		String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, NOTICE.*" 
		+ " FROM NOTICE, (SELECT @ROWNUM := 0)TMP WHERE " +field+ " LIKE ? ORDER BY date DESC limit ?, 10;";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + query + "%");
			pst.setInt(2, 0+(page-1)*10);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				int n = rs.getInt("n");
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date date = rs.getDate("date");

				Notice notice = new Notice(
						n
						, num
						, title
						, writer
						, date
				);
				list.add(notice);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();

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

	public int getNoticeCount() {

		return getNoticeCount("title", "");
	}

	/* paging */
	public int getNoticeCount(String field, String query) {
		int count = 0;

		String sql = "SELECT COUNT(num) as count FROM NOTICE"; 

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()) 
				count = rs.getInt("count");
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return count;
	}

	/* notice_detail */
	public Notice getNotice(int num) {
		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE WHERE num = ?";
			
		Connection conn = null;
		PreparedStatement pst = null;	
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);
		
			rs = pst.executeQuery();
			

			while (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date date = rs.getDate("date");
				String content = rs.getString("content");
				String file = rs.getString("file");
				
				notice = new Notice(
						title
						, writer
						, date
						, content
						, file
						);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pst != null)
					pst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return notice;
	}

	public Notice getNextNotice(int id) {
//		?????? ?????? ??????
		return null;
	}

	public Notice getPrevNotice(int id) {
//		?????? ?????? ??????
		return null;
	}

	public int delNoticeAll(int[] ids) {
		int result = 0;
		
		String params = "";
		
		for (int i=0; i<ids.length; i++) {
			params += ids[i];
			if(i<ids.length-1)
				params += ",";
		}
		
		String sql = "DELETE FROM NOTICE WHERE num IN ("+params+")"; 

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			st = conn.createStatement();
			
			result = st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (st != null)
					st.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return result;
	}
}
