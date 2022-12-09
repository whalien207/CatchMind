package com.example.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> inquireBoard(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		//DAO
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardVO> list = dao.inquireBoard();
		
		return list;
	}
	
	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		//a태그로 넘어오는 parameter
		String bno = request.getParameter("bno");
		
		//DAO생성
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(bno);
		
		return vo;
	}
	
}
