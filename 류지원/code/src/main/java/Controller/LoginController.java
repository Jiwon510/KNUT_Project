package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VIEW/login/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		String password = request.getParameter("password");
		String authority = request.getParameter("authority");
		
//		System.out.println(studentID);
//		System.out.println(password);
//		System.out.println(authority);
		
		HttpSession session = request.getSession();
		session.setAttribute("authority", authority);
		session.setAttribute("studentID", studentID);
		
		String query = "SELECT studentID, password from User WHERE studentID = ? AND password = ? AND authority = ?";
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
			
			pst.setString(1, studentID);
			pst.setString(2, password);
			pst.setString(3, authority);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				response.sendRedirect("/VIEW/index/index");
			}
			else {
				response.sendRedirect("/VIEW/login/login.jsp");
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
	}
}

