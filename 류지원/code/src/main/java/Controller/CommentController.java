package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CommentService;
import entity.Comment;

@WebServlet("/comment")
public class CommentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		String name = (String)session.getAttribute("name");
		
//		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		
//		System.out.println(name);
//		System.out.println(content);
//		System.out.println(notice_num);
		
		
		CommentService service = new CommentService();
//	    List<Comment> list = service.insertComment(name, content, notice_num);
	    List<Comment> list_2 = service.getCommentList(notice_num);
		
		response.sendRedirect("/VIEW/noticeDetail/noticeDetail"	);
	}
	
}
