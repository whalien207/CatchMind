package com.example.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.util.JDBCUtil;

public class UserDAO {

	private static UserDAO instance = new UserDAO();

	private UserDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("드라이버클래스 로드에러");
		}

	}

	public static UserDAO getInstance() {
		return instance;
	}


	public String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public String UID = "jsp";
	public String UPW = "jsp";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	//포인트 조회메서드
	public UserVO inquirePoints(String id) {
		UserVO vo = null;

		String sql = "select * from users where id = ?";

		try {
			conn = DriverManager.getConnection(URL, UID, UPW);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String id2 = rs.getString("id");
				String name2 = rs.getString("name");
				int point2 = rs.getInt("point");

				vo = new UserVO(id2, null, name2, point2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return vo;
	}


}
