package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.login.*;
import com.example.util.JDBCUtil;

public class UserDAO {
	/*
	 * UserDAO는 불필요하게 여러개 만들어질 필요가 없기 때문에 10명이 들어오면 10개가 생성되지만
	 * 쓰이는 기능은 똑같음. 한개의 객체만 만들어지도록 싱글톤 설계
	 */
	
	//1. 나 자신의 객체를 생성해서 1개로 제한한다.
	private static UserDAO instance = new UserDAO();
	
	// 2. 직접 객체를 생성할 수 없도록 생성자에 private
	private UserDAO() {
		//드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			System.out.println("드라이버 클래스 로드 에러");
		}
		
	}
	
	//3. 외부에서 객체 생성을 요구할 때 getter 메서드를 통해서 1번의 객체 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	//4. 필요한 데이터베이스 변수 선언
	public String URL = "jdbc:oracle:thin:@172.30.1.2:1521:xe";
	public String UID = "catchm";
	public String UPW = "catchm";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//5. 메서드
	public int idCheck(String id) {
		
		int result = 0;
		String sql = "select count(*) as total from users where id=?";
		
		try {
			//1. conn 객체
			conn= DriverManager.getConnection(URL, UID, UPW);
			//2. pstmt객체
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//3. 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("total");
			}
			
		} catch (Exception e) {
			
			e.getStackTrace();
		} finally {
			
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//회원가입
	public void join(UserVO vo) {
		String sql = "insert into users values(?,?,0,?)";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			
			pstmt.executeUpdate(); //실행(성공시 1 반환, 실패시 0반환)
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
	
	//로그인
	public UserVO login(String id, String pw) {
		
		UserVO vo = null;
		String sql = "select * from users where id=? and pw=?";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs= pstmt.executeQuery();
			if(rs.next()) { //로그인 성공 후 vo에 회원정보 저장
				String name = rs.getString("name");
				String id2 = rs.getString("id");
				String pw2 = rs.getString("pw");
				String point = rs.getString("point");
				
				vo = new UserVO(id2,pw2,name,point);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	
	//정보 조회
	public UserVO getInfo(String id) {
		
		UserVO vo = new UserVO();
		String sql = "select * from users where id=?";
		
		try {
			conn = DriverManager.getConnection(URL,UID,UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String point = rs.getString("point");
				
				vo = new UserVO(id2, null, name, point);
			} else {}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//회원정보 수정
	public int update(String id, String pw, String name) {
		
		int result = 0;
		String sql = "update users set pw=?, name=? where id=?";
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//포인트 조회메서드
	public int inquirePoints(String id) {
		String sql = "select point from users where id = ?";
		int point = 0;
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				point = rs.getInt("point");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return point;
	}
	
	public void updatePoint(String user, int point) {
		System.out.println(user);
		System.out.println(point);
		
		String sql = "update users set point = ? where id = ?";
		
		
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			//2. 포인트에 +10점하여 update
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, user);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
}
