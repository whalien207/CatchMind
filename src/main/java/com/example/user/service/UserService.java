package com.example.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.user.model.UserVO;

public interface UserService {
	
	public UserVO inquirePoints(HttpServletRequest request, HttpServletResponse response);
	

}
