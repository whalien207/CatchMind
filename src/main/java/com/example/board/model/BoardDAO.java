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
			System.out.println("board : 드라이버 클래스 로드 에러");
			e.printStackTrace();
		}
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	public String URL = "jdbc:oracle:thin:@172.30.1.2:1521:xe";
	public String UID = "catchm";
	public String UPW = "catchm";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void writeContent(String writer, String title, String Imgfile, String answer, String hint) {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0, ?, '진행중', ?)";

		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, Imgfile);
			pstmt.setString(4, answer);
			pstmt.setString(5, hint);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
	
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
				vo.setBno( rs.getInt("bno"));
				vo.setId( rs.getString("id") );
				vo.setTitle( rs.getString("title") );
				vo.setImg(rs.getString("img"));
				vo.setRegdate( rs.getTimestamp("regdate") );
				vo.setHit( rs.getInt("hit")) ;
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
	
	public void updateStatus(String bno) {
		String sql = "update board set status = ? where bno = ?";

		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "완료됨");
			pstmt.setString(2, bno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
	
	public void regist(String writer, String title, String content) {
		String sql = "insert into board values(board_seq.NEXTVAL,?,?,?,sysdate,0)";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

	}
	
	public ArrayList<BoardVO> getList(){
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * from board order by bno desc";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setImg(rs.getString("img"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setHit(rs.getInt("hit"));
				vo.setAnswer(rs.getString("answer"));
				vo.setStatus(rs.getString("status"));
				vo.setHint(rs.getString("hint"));
				list.add(vo);
				
			}		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//삭제기능
	public int delete(String bno) {
		int result=0;
		
		String sql = "delete from board where bno=?";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return result;
		
	}
	
	//내가 쓴 글 조회메서드
	public ArrayList<BoardVO> inquireBoard(String id) {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * from board where id = ? order by bno desc";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String id2 = rs.getString("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				String answer = rs.getString("answer");
				String status = rs.getString("status");
				String hint = rs.getString("hint");
					
				BoardVO vo = new BoardVO(bno, id2, title, img, regdate, hit, answer, status, hint);
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
