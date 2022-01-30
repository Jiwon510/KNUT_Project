package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.MemberService;

@WebServlet("/VIEW/index/index")
public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String studentID = (String)session.getAttribute("studentID");
//		System.out.println(studentID);
		
		MemberService service = new MemberService();
		String name = service.getMemberName(studentID);
		session.setAttribute("name", name);
		
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("/VIEW/index/index.jsp").forward(request, response);
	}

}
