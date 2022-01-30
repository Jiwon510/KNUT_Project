package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import entity.Comment;
import entity.Notice;
import entity.Write;

public class CommentService {
	
	public List<Comment> insertComment(String writer, String content, int notice_num) {
		
		List<Comment> list= new ArrayList<>();
		
		String sql = "INSERT INTO COMMENT(writer, content, notice_num) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(sql);
			pst.setString(1, writer);
			pst.setString(2, content);
			pst.setInt(3, notice_num);
			
			int rs = pst.executeUpdate();

			Comment comment = new Comment (
					writer
					, content
					, notice_num
					);
			list.add(comment);
			

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
	
	public List<Comment> getCommentList(int notice_num) {
		
		List<Comment> list = new ArrayList<>();
		
		String sql = "select * from comment where notice_num = ?";
		
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
			pst.setInt(1, notice_num);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				

				Comment comment = new Comment(
						writer
						, content
						, date
				);
				list.add(comment);
				System.out.println(list);
				
				
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
}
