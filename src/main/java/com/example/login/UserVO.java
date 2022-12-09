package com.example.login;

public class UserVO {
	
	//화면 and 데이터베이스 컬럼과 동일한 멤버변수를 가집니다.
	private String id;
	private String pw;
	private String name;
	private String point;
	
	public UserVO() {}

	public UserVO(String id, String pw, String name, String point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}


	
	

}
