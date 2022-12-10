package com.example.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.login.*;

public interface UserService {
	public int join(HttpServletRequest request, HttpServletResponse response); //가입처리
	public UserVO login(HttpServletRequest request, HttpServletResponse response); //로그인
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response); //회원정보조회
	public int update(HttpServletRequest request, HttpServletResponse response); //회원정보수정
	public UserVO inquirePoints(HttpServletRequest request, HttpServletResponse response);
}
