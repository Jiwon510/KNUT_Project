package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.JoinService;
import entity.User;



@WebServlet("/VIEW/join/join")
public class JoinController extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String name = request.getParameter("name");
      String studentID = request.getParameter("studentID");
      String password = request.getParameter("password");
      String department = request.getParameter("department");
      String email = request.getParameter("email");
      String address = request.getParameter("address");
      String detailAddress = request.getParameter("detailAddress");
      String motive = request.getParameter("motive");
      String authority = request.getParameter("authority");
      
      JoinService service = new JoinService();
      List<User> list = service.getjoin(name, studentID, password, department, email, address, detailAddress, motive, authority);
          
      response.sendRedirect("VIEW/login/login.jsp");
   }
}
