package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		//서비스객체
		BoardServiceImpl service = new BoardServiceImpl();
		
		//세션
		
		// 요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		String command = uri.substring(path.length());

		HttpSession session = request.getSession();
		System.out.println("요청경로:" + command);
		if (command.equals("/board/board_write.board")) { // 등록화면
			if(session.getAttribute("user_id") == null) {
				response.sendRedirect("../user/user_login.user");
				return;
			}
			
			request.getRequestDispatcher("board_write.jsp").forward(request, response);
			
		} else if (command.equals("/board/board_list.board")) { // 목록화면
			//조회 메서드 - list를 화면으로 가지고 나감
			ArrayList<BoardVO> list= service.getList(request, response);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("board_list.jsp").forward(request, response);
			
		} else if (command.equals("/board/board_content.board")) { // 상세내용화면
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_content.jsp").forward(request, response);
			
		} else if (command.equals("/board/board_modify.board")) { // 수정화면
			//조회한 글에 대한 정보 조회 재활용
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);
			
		} else if (command.equals("/board/registForm.board")) { //글 등록
			/*
			 * 1. service의 regist메서드로 연결
			 * 2. service에서 등록에 필요한 파라미터를 받습니다.
			 * 3. dao의 void regist메서드를 생성하고 insert작업
			 * 4. insert이후에 컨트롤러에서 리스트화면으로 리다이렉트
			 */
			service.regist(request, response);
			response.sendRedirect("board_list.board");
			
		} else if (command.equals("/board/updateForm.board")) {
			service.update(request, response);
			//1st
			//response.sendRedirect("board_list.board");
			
			//2nd
			response.sendRedirect("board_content.board?bno="+request.getParameter("bno"));
		} else if (command.equals("/board/board_delete.board")) {
			int result = service.delete(request, response);
			String msg = "";
			
			if(result==1) { //삭제성공
				msg= "삭제 성공";
			} else {//삭제 실패
				msg= "삭제 실패";
				
			}
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("location.href='board_list.board';");
			out.println("</script>");
			
		}
	}

}

