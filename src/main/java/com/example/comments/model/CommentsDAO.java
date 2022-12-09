package com.example.comments.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentsDAO {

	private static CommentsDAO instance = new CommentsDAO();
	
	private CommentsDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버클래스 로드에러");
		}
	}
	
	public static CommentsDAO getInstance() {
		return instance;
	}
	
	public String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public String UID = "jsp";
	public String UPW = "jsp";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//내가 쓴 댓글 조회메서드
	public ArrayList<CommentsVO> inquireComments() {
		
		ArrayList<CommentsVO> list = new ArrayList<>();
		
		String sql = "select * from comments order by "
		
	}
	
	
}
