package com.example.comments.model;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public String UID = "catchm";
	public String UPW = "catchm";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	//내가 쓴 댓글 조회메서드
	public ArrayList<CommentsVO> inquireComments() {

		ArrayList<CommentsVO> list = new ArrayList<>();

		String sql = "select * from comments where bno = ? order by bno desc";

		try {
			conn = DriverManager.getConnection(URL, UID, UPW);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "bno");

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int cno = rs.getInt("cno");
				String comments = rs.getString("comments");
				int bno = rs.getInt("bno");
				String id = rs.getString("id");
				Timestamp regdate = rs.getTimestamp("regdate");			

				CommentsVO vo = new CommentsVO(cno, comments, bno, id, regdate);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}


}
