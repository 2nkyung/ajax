package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uiId = request.getParameter("ui_id");
		String uiPwd = request.getParameter("ui_pwd");
		String uiName = request.getParameter("ui_name");
		String uiEmail = request.getParameter("ui_email");
		String cmd = request.getParameter("cmd");
		Map<String,String> user = new HashMap<>();
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		user.put("uiName", uiName);
		user.put("uiEmail", uiEmail);
		if("insert".equals(cmd)) {
			int cnt = 0;
			if(user.get("uiId") != null) {
				cnt = us.insertUser(user);
			}
		}
		System.out.println(user);
	}

}
