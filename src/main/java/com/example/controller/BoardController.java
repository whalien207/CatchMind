package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.model.BoardVO;
import com.example.board.service.BoardServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		BoardServiceImpl service = new BoardServiceImpl();
				
		HttpSession session = request.getSession();
		
		if(command.equals("/user/user_content.board")) {
			
			ArrayList<BoardVO> list = service.inquireBoard(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("user_content.jsp").forward(request, response);
		}
		
	}
	
	
	

}
