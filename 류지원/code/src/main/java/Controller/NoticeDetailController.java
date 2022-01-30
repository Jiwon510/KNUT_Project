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
		
		int num = Integer.parseInt(request.getParameter("num"));
		

		NoticeService N_service = new NoticeService(); 
		CommentService C_service = new CommentService();
		
		Notice notice = N_service.getNotice(num);
		System.out.println(notice);
//		List<Comment> list = C_service.getCommentList(num);
		
//		request.setAttribute("list", list);
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("/VIEW/noticeDetail/noticeDetail.jsp").forward(request, response);
	}
}
