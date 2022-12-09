package com.example.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.example.util.JDBCUtil;

public class BoardDAO {


	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버클래스 로드에러");
		}

	}

	public static BoardDAO getInstance() {
		return instance;
	}
	
	public String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public String UID = "jsp";
	public String UPW = "jsp";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	//내가 쓴 글 조회메서드
	public ArrayList<BoardVO> inquireBoard() {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * from board where id = ? order by bno desc";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "id");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				String answer = rs.getString("answer");
				String status = rs.getString("status");
				String hint = rs.getString("hint");
					
				BoardVO vo = new BoardVO(bno, id, title, img, regdate, hit, answer, status, hint);
				list.add(vo);
				
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
				
		return list;
		
	}
	
	//세부내용 보는 메서드
	public BoardVO getContent(String bno) {
		
		BoardVO vo = null;
		
		String sql = "select * from board where bno = ?";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setImg(rs.getString("img"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setHit(rs.getInt("hit"));
				vo.setAnswer(rs.getString("answer"));
				vo.setStatus(rs.getString("status"));
				vo.setHint(rs.getString("hint"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return vo;
		
	}
	
	
}
