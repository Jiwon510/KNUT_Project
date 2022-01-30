package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Service.CommentService;
import Service.NoticeService;
import entity.Comment;
import entity.Notice;

@WebServlet("/VIEW/noticeDetail/noticeDetail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = (String)session.getAttribute("studentID");
		String content = request.getParameter("content");
		
//		System.out.println(num);
//		System.out.println(writer);
//		System.out.println(content);
//		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		
		
		NoticeService service = new NoticeService(); 
		CommentService service2 = new CommentService();
		List<Comment> list = service2.getCommentList(num);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/VIEW/noticeDetail/noticeDetail.jsp").forward(request, response);
//		response.sendRedirect("VIEW/noticeDetail/noticeDetail.jsp");
	}
}
