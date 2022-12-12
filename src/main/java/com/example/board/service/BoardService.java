package com.example.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardVO;
import com.example.comments.model.CommentsVO;

public interface BoardService {
	//글에 달린 댓글 리스트 읽어오기
	public ArrayList<CommentsVO> getComment(HttpServletRequest request, HttpServletResponse response); 
	public void writeComment(HttpServletRequest request, HttpServletResponse response); 
	public void writeContent(HttpServletRequest request, HttpServletResponse response); 
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response); 
	public ArrayList<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);//조회
	public int delete(HttpServletRequest request, HttpServletResponse response);//
	public ArrayList<BoardVO> inquireBoard(HttpServletRequest request, HttpServletResponse response);
	public void regist(HttpServletRequest request, HttpServletResponse response);
}
