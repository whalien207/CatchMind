package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.user.model.UserVO;
import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글처리
		request.setCharacterEncoding("utf-8");

		//요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());

		System.out.println("접속IP: " + request.getRemoteAddr());

		UserService service = new UserServiceImpl();

		HttpSession session = request.getSession();
		
		if(command.equals("/user/user_mypage_points.user")) {
			request.getRequestDispatcher("user_mypage_points.jsp").forward(request, response);
		}
		
		
		switch (command) {
		case "/user/user_mypage.user":

			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);


			break;
		case "/user/user_points.user":

			UserVO vo = service.inquirePoints(request, response);
			
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("user_points.jsp").forward(request, response);
			
			break;

		default:
			break;
		}


	}

}
