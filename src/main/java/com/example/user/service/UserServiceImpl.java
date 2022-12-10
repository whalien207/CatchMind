package com.example.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.user.model.UserDAO;
import com.example.user.model.UserVO;

public class UserServiceImpl implements UserService {

	@Override
	public UserVO inquirePoints(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.inquirePoints(id);
		
		return vo;
	}

}
