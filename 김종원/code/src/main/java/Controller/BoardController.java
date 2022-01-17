package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Board;

@WebServlet("/view/main/board")
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Board> list = new ArrayList<>();
		
		String query = "SELECT num, title, writer, date FROM Board ORDER BY NUM";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mysql://localhost:4406/test";
		String dbID = "root";
		String dbPassword = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
			int num = rs.getInt("num");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			Date date = rs.getDate("date");
			
			Board board = new Board(
					num
					,title
					,writer
					,date
			);
			list.add(board);
			
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				
				if(pst != null)
					pst.close();
				
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/main/user/board.jsp").forward(request, response);
	}		
}
