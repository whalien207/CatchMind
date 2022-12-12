package com.example.comments.model;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.comments.model.CommentsVO;
import com.example.util.JDBCUtil;

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

	public String URL = "jdbc:oracle:thin:@172.30.1.2:1521:xe";
	public String UID = "catchm";
	public String UPW = "catchm";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	//내가 쓴 댓글 조회메서드
	public ArrayList<CommentsVO> inquireComments(String id) {

		ArrayList<CommentsVO> list = new ArrayList<>();

		String sql = "select * from comments where id = ? order by bno desc";

		try {
			conn = DriverManager.getConnection(URL, UID, UPW);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int cno = rs.getInt("cno");
				String comments = rs.getString("comments");
				int bno = rs.getInt("bno");
				String id2 = rs.getString("id");
				Timestamp regdate = rs.getTimestamp("regdate");			

				CommentsVO vo = new CommentsVO(cno, comments, bno, id2, regdate);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	//bno번호로 해당 글에 맞는 comment읽어오기 (oder by 날짜 순서로..)
	public ArrayList<CommentsVO> getComment(String bno) {
		
		ArrayList<CommentsVO> commentList = new ArrayList<>();
		String sql = "select * from comments where bno = ? order by cno";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentsVO vo = new CommentsVO();
				vo.setCno(rs.getInt("cno"));
				vo.setComments(rs.getString("comments"));
				vo.setBno(rs.getInt("bno"));
				vo.setId(rs.getString("id"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				
				commentList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return commentList;
	}
	
	public void writeComment(String comment, String bno, String id) {
		String sql = "insert into comments values(comment_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setString(2, bno);
			pstmt.setString(3, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}

}
