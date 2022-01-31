package Controller;

import java.io.IOException;
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

import Service.MemberService;
import entity.User;

@WebServlet("/VIEW/permission/permission")
public class PermissionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field_ = request.getParameter("search");
		String query_ = request.getParameter("word");
		String page_ = request.getParameter("p");
		
		String field = "name";
		if (field_ != null && !field_.equals(""))
			field = field_;

		String query = "";
		if (query_ != null && !query_.equals(""))
			query = query_;

		int page = 1;
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		MemberService service = new MemberService();
		List<User> list = service.getNonMember(field, query, page);
		int count = service.getMemberCount(field, query);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
      
      request.getRequestDispatcher("/VIEW/permission/permission.jsp").forward(request, response);
	}
}
