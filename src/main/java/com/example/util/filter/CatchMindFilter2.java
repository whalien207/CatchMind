package com.example.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CatchMindFilter2
 */
@WebFilter({"/board/board_modify.board",
			"/board/board_delete.board"}) //경로
public class CatchMindFilter2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * 세션의 id와 request로 넘어오는 작성자가 다르면 수정 불가.
		 * 
		 * 1. 각 요청 경로에서 writer가 파라미터로 반드시 전달되도록 처리
		 */
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//각 요청에 넘어오는 writer 파라미터
		String writer = request.getParameter("writer");
		
		//세션에 저장된 id
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		System.out.println(writer);
		System.out.println("세션id" + id);
		
		//세션이 없거나 or 작성자와 세션이 다른 경우
		if(id == null || !writer.equals(id)) {
			
			String path = req.getContextPath(); //절대경로
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 필요한 기능입니다');");
			out.println("location.href='"+path+"/board/board_list.board"+ "';");
			out.println("</script>");
			
			return; //함수를 종료하면 컨트롤러로 연결 되지 않음
		}
		
		chain.doFilter(request, response);
	}


}
