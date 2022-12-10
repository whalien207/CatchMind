package com.example.controller;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.catalina.connector.Request;


public class BoardDAO {
	// UserDAO는 불필요하게 여러개 만들어질 필요가 없기 떄문에
		// 하나의 객체만 만들어지도록 Singleton형식으로 설계합니다.
		
		// 1.나자신의 객체를 생성해서 1개로 제한합니다.
		private static BoardDAO instance = new BoardDAO();

		// 2. 직접 객체를 생성 할 수 없도록 생성자에 private
		private BoardDAO() {
			// 드라이버 클래스 로드
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				System.out.println("드라이버클래스 로드에러");
			}
		}

		// 3.외부에서 객체생성을 요구할 때 getter메서드를 통해 1번의객체를 반환
		public static BoardDAO getInstance() {
			return instance;
		}

		// 4.필요한 데이터베이스 변수 선언
		private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		private String UID = "catchm";
		private String UPW = "catchm";

		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
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
		//글세부내용
		public BoardVO getContent(String bno) {
			BoardVO vo = null;
			String sql = "select * from board where bno=?";
			try {
				conn=DriverManager.getConnection(URL, UID, UPW);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bno );
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new BoardVO();
					vo.setBno(rs.getInt("bno"));
					vo.setTitle(rs.getString("title"));
					
					vo.setRegdate(rs.getTimestamp("regdate"));
					vo.setHit(rs.getInt("hit"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstmt, rs);
			}
			
			return vo;
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
		
		
}
