package com.example.comments.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentsService {

	public ArrayList<CommentsVO> inquireComments(HttpServletRequest request, HttpServletResponse response);
	
	
}
