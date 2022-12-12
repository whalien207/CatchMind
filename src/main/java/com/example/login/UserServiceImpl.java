package com.example.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.login.*;

public class UserServiceImpl implements UserService{
	//컨트롤러 역할을 분담
	//가입처리
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("아무거나");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String point = request.getParameter("point");
		
		//아이디나 이메일이 중복검사 -> 없으면 가입		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.idCheck(id);
		
		if(result >= 1) { //중복
			return 1;
		} else { //중복 아님
			UserVO vo = new UserVO(id, pw, name, point);
			dao.join(vo);
			return 0;
		}
		
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		return vo;
	}

	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		//세션에서 user_id 값을 얻음
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		//dao 객체 생성
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		return vo;
	}

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String point = request.getParameter("point");
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(id, pw, name);
		
		if(result == 1) { //세션값 변경
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} 
		return result;
	}
	@Override
	public UserVO inquirePoints(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String point = request.getParameter("point");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		return vo;
	}
}
