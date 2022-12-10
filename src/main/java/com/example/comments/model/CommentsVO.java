package com.example.comments.model;

import java.sql.Timestamp;

public class CommentsVO {

	private int cno;
	private String comments;
	private int bno;
	private String id;
	private Timestamp regdate;
	
	
	public CommentsVO() {
	}


	public CommentsVO(int cno, String comments, int bno, String id, Timestamp regdate) {
		super();
		this.cno = cno;
		this.comments = comments;
		this.bno = bno;
		this.id = id;
		this.regdate = regdate;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	
	
	
}
