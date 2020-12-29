package jstlel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class _02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * 1. 객체가 오래 존속되는 순서
		 * 
		 * Application(Context) Scope > Session Scope > Request Scope > Page Scope
		 * 
		 * 2. EL에서 이름을 찾는 순서
		 * 
		 * Application(Context) Scope < Session Scope < Request Scope < Page Scope
		 * 
		 * 
		 * 주의 : 같은 이름으로 여러 범위의 객체를 저장하지 말것 !
		 */
		
		// request scope
		UserVo vo1 = new UserVo();
		vo1.setNo(1L);
		vo1.setName("김송현1");
		request.setAttribute("vo",vo1);
		
		// session scope
		UserVo vo2 = new UserVo();
		vo2.setNo(2L);
		vo2.setName("김송현2");

		HttpSession session = request.getSession(true);
		session.setAttribute("vo", vo2);
		
		
		request.getRequestDispatcher("/WEB-INF/views/02.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
