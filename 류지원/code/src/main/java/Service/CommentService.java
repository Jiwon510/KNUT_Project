package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import entity.Comment;
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
}
