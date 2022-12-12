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
 * Servlet Filter implementation class CatchMindFilter
 */
@WebFilter({"/board/board_write.board", 
			"/board/board_list.board",
			"/board/board_content.board",
			"/board/board_modify.board",
			"/board/registForm.board",
			"/board/board_delete.board"})
public class CatchMindFilter implements Filter {
       


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//필터 실질 역할 담당
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//req에서 세션을 얻음
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		//user_id == null이라면 권한이 없다는 의미
		if(id == null) {
			String path = req.getContextPath(); //절대경로라 좀 더 안전함
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 필요한 기능입니다');");
			out.println("location.href='"+path+"/user/user_login.user"+ "';");
			out.println("</script>");
			
			return; //함수를 종료하면 컨트롤러로 연결 되지 않음
		}
		
		chain.doFilter(request, response); //필터가 여러개라면 다음 필터로 연결함
	}



}
