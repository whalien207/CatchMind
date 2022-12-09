package com.example.comments.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.comments.model.CommentsVO;

public interface CommentsService {

	public ArrayList<CommentsVO> inquireComments(HttpServletRequest request, HttpServletResponse response);
	
	
}
