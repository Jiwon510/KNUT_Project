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

@WebServlet("/VIEW/noticeDetail/noticeDetail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeService service = new NoticeService(); 
		Notice notice = service.getNotice(num);
		request.setAttribute("n", notice);

		
		request.getRequestDispatcher("/VIEW/noticeDetail/noticeDetail.jsp").forward(request, response);
	}
}
