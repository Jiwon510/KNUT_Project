package entity;

import java.util.Date;

public class Notice {
	private int n;
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date date;
	
	public Notice(String title, String writer, Date date, String content) {
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.content = content;
	}
	
	public Notice(int n, int num, String title, String writer, Date date) {
		this.n = n;
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public Notice(int n, int num, String title, String writer, String content, Date date) {
		this.n = n;
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Notice [n=" + n + ", num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", date=" + date + "]";
	}
}