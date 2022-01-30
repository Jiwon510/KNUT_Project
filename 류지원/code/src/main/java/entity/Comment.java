package entity;

import java.util.Date;

public class Comment {
	private int n;
	private int num;
	private String writer;
	private String content;
	private Date date;
	private int notice_num;
	
	public Comment(String writer, String content, int notice_num) {
		this.writer = writer;
		this.content = content;
		this.notice_num = notice_num;
	}

	public Comment(int n, int num, String writer, String content, Date date, int notice_num) {
		this.n = n;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.notice_num = notice_num;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	@Override
	public String toString() {
		return "Comment [n=" + n + ", num=" + num + ", writer=" + writer + ", content=" + content + ", date=" + date
				+ ", notice_num=" + notice_num + "]";
	}
}
