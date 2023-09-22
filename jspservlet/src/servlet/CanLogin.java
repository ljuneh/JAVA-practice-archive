package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CanLogin")
public class CanLogin extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		int count = Integer.valueOf(req.getParameter("conncount"));
		
		ServletContext context = getServletContext();
		int maxCount = Integer.valueOf(context.getInitParameter("max_connection_count"));
		
		
		String message = "";
		
		if(count<=maxCount) {
			message = id + "님 접속 환영합니다";
		} else {
			message = id + "님 접속 횟수를 초과했습니다";
		}
		
		PrintWriter out = resp.getWriter();
		
		out.append(message);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
