package com.testweb.board.model;

import java.sql.Timestamp;

public class BbsVO {

	private int bno;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate;
	
	public BbsVO() {
		// TODO Auto-generated constructor stub
	}

	public BbsVO(int bno, String writer, String title, String content, Timestamp regdate) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
