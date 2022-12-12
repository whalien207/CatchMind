package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.comments.model.CommentsVO;
import com.example.comments.service.CommentsServiceImpl;

@WebServlet("*.comments")
public class CommentsController extends HttpServlet {
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

		System.out.println("요청경로" + command);


		//서비스객체
		CommentsServiceImpl service = new CommentsServiceImpl();

		//세션
		HttpSession session = request.getSession();
		
		//내가 쓴 댓글 조회하기 
		if(command.equals("/user/user_comments.comments")) {
			
			ArrayList<CommentsVO> list = service.inquireComments(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("user_comments.jsp").forward(request, response);
			
		}
		
	}

}
