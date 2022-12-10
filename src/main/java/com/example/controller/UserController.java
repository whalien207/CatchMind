package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.login.UserService;
import com.example.login.UserServiceImpl;
import com.example.login.UserVO;


@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	//get, post 하나로 묶음	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length());
		
		System.out.println("요청경로" + command);
		UserService service = new UserServiceImpl();
		
		switch (command) {
		case "/user/user_join.user": 
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
			
			break;
			
			
		case "/user/joinForm.user": //회원가입
			
			int result = service.join(request, response);
			
			if(result >= 1) { //아이디중복 
				//메세지
				request.setAttribute("msg", "이미 존재하는 아이디입니다.");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { //가입성공
				//MVC2에서 리다이렉트는 다시 컨트롤러를 태우는 요청
				response.sendRedirect("user_login.user");
			}
			
			break;
			
			
			
		case "/user/user_login.user": //로그인페이지
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
			
			break;
			
			
			
		case "/user/loginForm.user": //로그인요청
			
			UserVO vo = service.login(request, response);
			
			if(vo == null) { //로그인 실패
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
			} else {//로그인 성공
				//세션에 아이디, 이름 저장
				HttpSession session = request.getSession(); //자바에서 현재 세션 얻는 방법
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
				
				//메인페이지
				response.sendRedirect("../main.jsp");
			}
			
			break;
		
			
		case "/user/user_logout.user": //로그아웃
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(path + "/index.main"); //메인으로
			
			break;
			

		default:
			break;
		}
	}
	

}
