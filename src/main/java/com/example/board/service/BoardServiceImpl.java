package com.example.board.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;
import com.example.comments.model.CommentsDAO;
import com.example.comments.model.CommentsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardServiceImpl implements BoardService{

	@Override //글에 달린 댓글 리스트 읽어오기
	public ArrayList<CommentsVO> getComment(HttpServletRequest request, HttpServletResponse response) {
		//보드의 리스트(목록)에서 사진 클릭시 GET방식으로 bno를 붙여서 가지고 올 수 있다. 
		String bno = request.getParameter("bno");
		
		CommentsDAO dao = CommentsDAO.getInstance();
		ArrayList<CommentsVO> commentList = dao.getComment(bno);
		
		return commentList;
	}
	
	@Override //댓글 등록
	public void writeComment(HttpServletRequest request, HttpServletResponse response) {
		String comment = request.getParameter("comment");
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		
		/* board 테이블에 저장된 answer(정답)이랑 비교하여 board의 status를 바꿔주기 */
		BoardDAO b_dao = BoardDAO.getInstance();
		BoardVO bvo = b_dao.getContent(bno);
		
		//만약 등록한 답과 입력한 댓글이 일치한다면 (= 정답)
		if(bvo.getAnswer().equals(comment)) {
			//1.user에게 포인트 적립
			HttpSession session = request.getSession();
			String user = (String)session.getAttribute("id");
			
			//user id로 조건을 주고 포인트 update해주기
			//UserDAO u_dao = UserDAO.getInstance();
			//u_dao.updatePoint(user);
			
			//2.baord에 status변경
			b_dao.updateStatus(bno);
		}
		
		CommentsDAO c_dao = CommentsDAO.getInstance();
		c_dao.writeComment(comment, bno, id);
	}
	
	@Override //글 등록
	public void writeContent(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * 글을 등록하면 이미지를 저장하고
		 * DB에 이미지 이름과 나머지 입력한 정보들 넣어주기 
		 */
		
		String save_location = request.getRealPath("img");
		int maxSize = 1024 * 1024 * 5; // 키로바이트 * 메가바이트 * 기가바이트   
		
		/*multipart로 data가지고 오기*/
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, save_location, maxSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String Imgfile = multi.getParameter("imgFile");
		String answer = multi.getParameter("answer");
		String hint = multi.getParameter("hint");
		
		Enumeration files = multi.getFileNames();
        String str = (String)files.nextElement();
        String file = multi.getFilesystemName(str);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.writeContent(writer, title, file, answer, hint);
	}
	
	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(bno);
		
		return vo;
	}
	
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
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.delete(bno);
		
		return result;
	}
	
	@Override
	public ArrayList<BoardVO> inquireBoard(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		//DAO
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardVO> list = dao.inquireBoard(id);
		
		return list;
	}
	
}
