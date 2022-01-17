package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.NoticeService;
import entity.Notice;



@WebServlet("/notice/notice")
public class NoticeController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
//	  ?search=제목&word=asdf
//	   String authority = request.getParameter("authority");
//	   System.out.println(authority);
//	   
//	   HttpSession session = request.getSession();
//	   session.setAttribute("authority", authority);
	  
	  
	  String field_ = request.getParameter("search");
	  String query_ = request.getParameter("word");
	  String page_ = request.getParameter("p");
	  
	  String field = "title";
	  if(field_ != null && !field_.equals(""))
		  field = field_;
	  
	  String query = "";
	  if(query_ != null && !query_.equals(""))
		  query = query_;
	  
	  int page = 1;
	  if(page_ != null && !page_.equals(""))
		  page = Integer.parseInt(page_);
	   
      NoticeService service = new NoticeService();
      List<Notice> list = service.getNoticeList(field, query, page);
      int count = service.getNoticeCount(field, query);
      
      request.setAttribute("list", list);
      request.setAttribute("count", count);
      
      request.getRequestDispatcher("/notice/notice.jsp").forward(request, response);
   }      
}