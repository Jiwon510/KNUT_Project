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

import Service.BoardService;
import Service.CommentService;
import entity.Board;
import entity.Comment;


@WebServlet("/VIEW/boardDetail/boardDetail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		

		BoardService B_service = new BoardService(); 
		CommentService C_service = new CommentService();
		
		Board board = B_service.getBoard(num);
		System.out.println(board);
//		List<Comment> list = C_service.getCommentList(num);
		
//		request.setAttribute("list", list);
		request.setAttribute("b", board);
		
		request.getRequestDispatcher("/VIEW/boardDetail/boardDetail.jsp").forward(request, response);
	}
}
