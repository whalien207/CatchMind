package com.example.comments.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.comments.model.CommentsDAO;
import com.example.comments.model.CommentsVO;

public class CommentsServiceImpl implements CommentsService{

	@Override
	public ArrayList<CommentsVO> inquireComments(HttpServletRequest request, HttpServletResponse response) {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		CommentsDAO dao = CommentsDAO.getInstance();
		ArrayList<CommentsVO> list = dao.inquireComments(bno);
		
		
		
		return list;
	}
}
