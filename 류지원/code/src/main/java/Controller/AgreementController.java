package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VIEW/agreement/agreement")
public class AgreementController extends HttpServlet{
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		  
		String chk_1 = request.getParameter("chk_1");
		String chk_2 = request.getParameter("chk_2");
		
		/* 예외처리 */
		if (chk_1 == null) 
			chk_1 = "0";
		if (chk_2 == null)
			chk_2 = "0";
		
		if (chk_1.equals("0") && chk_2.equals("0")) {
			out.print("<script>alert('KNUTCLUB 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.')</script>");
			out.print("<script>location.href='/VIEW/agreement/agreement.jsp'</script>");
		}
		else if (chk_1.equals("0")) {
			out.print("<script>alert('KNUTCLUB 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.')</script>");
			out.print("<script>location.href='/VIEW/agreement/agreement.jsp'</script>");
		}
		else if (chk_2.equals("0")) {
			out.print("<script>alert('KNUTCLUB 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.')</script>");
			out.print("<script>location.href='/VIEW/agreement/agreement.jsp'</script>");
		}
		out.print("<script>location.href='/VIEW/join/join.jsp'</script>");
		out.close();
		
			  
	}
}
