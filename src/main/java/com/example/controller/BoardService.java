package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface BoardService {
	public void regist(HttpServletRequest request, HttpServletResponse response);//등록
	
	public ArrayList<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);//조회
	
	BoardVO getContent(HttpServletRequest request, HttpServletResponse response);//조회
	
	void update(HttpServletRequest request, HttpServletResponse response);//정보수정
	
	int delete(HttpServletRequest request, HttpServletResponse response);//
	
}
