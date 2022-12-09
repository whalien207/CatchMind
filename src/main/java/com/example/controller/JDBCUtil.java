package com.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) conn.close();
			if(rs != null) conn.close();
			
		} catch (Exception e) {
			System.out.println("closs에러");
		}
	}
}
