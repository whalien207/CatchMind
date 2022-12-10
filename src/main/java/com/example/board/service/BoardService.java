package com.example.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardVO;

public interface BoardService {

	public ArrayList<BoardVO> inquireBoard(HttpServletRequest request, HttpServletResponse response);
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	
}
