package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Notice;
import entity.User;

public class MemberService {
	public List<User> getMember(String field, String query, int page) {
			
			List<User> list= new ArrayList<>();
			
			String sql = "SELECT name, studentID, department FROM USER WHERE authority = 1"
					+ " AND " +field+ " LIKE ? ";
					
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
		     
		       rs = pst.executeQuery();
		         
		       while(rs.next()) {
		       String name = rs.getString("name");
		       String studentID = rs.getString("studentID");
		       String department = rs.getString("department");
		         
		       User user = new User(
		              name
		             ,studentID
		             ,department
		       );
		       list.add(user);
		         
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
		    
		return list;
		}
	
	public List<User> getNonMember(String field, String query, int page) {
		
		List<User> list= new ArrayList<>();
		
		String sql = "SELECT name, studentID, department FROM USER WHERE authority = 0"
				+ " AND " +field+ " LIKE ? ";
				
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
	     
	       rs = pst.executeQuery();
	         
	       while(rs.next()) {
	       String name = rs.getString("name");
	       String studentID = rs.getString("studentID");
	       String department = rs.getString("department");
	         
	       User user = new User(
	              name
	             ,studentID
	             ,department
	       );
	       list.add(user);
	         
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
	    
	return list;
	}
	
	public int getMemberCount(String field, String query) {
		int count = 0;

		String sql = "SELECT COUNT(num) as count FROM USER where authority = 1"; 

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
	
	public int getNonMemberCount(String field, String query) {
		int count = 0;

		String sql = "SELECT COUNT(num) as count FROM USER where authority = 0"; 

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
	
	public String getMemberName(String studentID) {
		String name = null;
		
		String sql = "SELECT name FROM USER where studentID = ?"; 

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
			pst.setString(1, studentID);
			
			rs = pst.executeQuery();
			
			if(rs.next()) 
				name = rs.getString("name");
			
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
		return name;
	}
}
