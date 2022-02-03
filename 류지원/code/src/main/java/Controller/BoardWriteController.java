package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.WriteService;
import entity.Write;

@WebServlet("/VIEW/boardWrite/boardWrite")
public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int like_count = 0;
		
		WriteService service = new WriteService();
	    List<Write> list = service.WriteBoard(title, writer, content, like_count);
	    
	    request.setAttribute("list", list);	
	    request.getRequestDispatcher("/VIEW/board/board").forward(request, response);
	}
}
