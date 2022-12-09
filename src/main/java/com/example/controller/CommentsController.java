package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.service.BoardServiceImpl;

@WebServlet("/CommentsController")
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
		BoardServiceImpl service = new BoardServiceImpl();

		//세션
		HttpSession session = request.getSession();
	}

}
