package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticeService;
import entity.Notice;

@WebServlet("/view/main/noticedetail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		NoticeService service = new NoticeService(); 
		Notice notice = service.getNotice(num);
		request.setAttribute("n", notice);

		
		request.getRequestDispatcher("/view/main/detail.jsp").forward(request, response);
	}
}
