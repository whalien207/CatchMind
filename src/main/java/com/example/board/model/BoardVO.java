package com.example.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int bno;
	private String id;
	private String title;
	private String img;
	private Timestamp regdate;
	private int hit;
	private String answer;
	private String status;
	private String hint;
	
	public BoardVO() {
	}

	public BoardVO(int bno, String id, String title, String img, Timestamp regdate, int hit, String answer,
			String status, String hint) {
		super();
		this.bno = bno;
		this.id = id;
		this.title = title;
		this.img = img;
		this.regdate = regdate;
		this.hit = hit;
		this.answer = answer;
		this.status = status;
		this.hint = hint;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
	
}
