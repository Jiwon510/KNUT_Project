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

@WebServlet("/view/main/permission")
public class PermissionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("check");
		
		String query = "UPDATE user SET authority = ?";
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
			
			/*
			 * pst.setString(1, 1); rs = pst.executeUpdate();
			 */
			
			if(rs.next()) {
				if("1".equals(check)) {
					
				}
				
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
		
		response.sendRedirect("/view/main/admin/non_memberList.jsp");
	}
}
