package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardServiceImpl implements BoardService{

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);
	}

	@Override
	public ArrayList<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		//DAO
		BoardDAO dao=BoardDAO.getInstance();
		ArrayList<BoardVO> list = dao.getList();
		
		return list;
	}

	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		//a태그로 넘어오는 param
		String bno = request.getParameter("bno");
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(bno);
		
		//조회수 기능(중복방지 쿠키)
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 넘어오는 값
		String bno = request.getParameter("bno");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.update(bno, title, content);
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.delete(bno);
		
		return result;
	}

	
	
}
