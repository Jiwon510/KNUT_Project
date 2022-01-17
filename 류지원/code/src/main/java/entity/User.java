package entity;

import java.util.Date;

public class User {
	private int num;
	private String name;
	private String studentID;
	private String password;
	private String department;
	private String email;
	private String address;
	private String detailAddress;
	private Date date;
	private String motive;
	private String authority;
	
	public User(String name, String studentID, String department) {
		this.name = name;
		this.studentID = studentID;
		this.department = department;
	}
	
	public User(String name, String studentID, String password, String department, String email,
			String address, String detailAddress, String motive, String authority) {
		this.name = name;
		this.studentID = studentID;
		this.password = password;
		this.department = department;
		this.email = email;
		this.address = address;
		this.detailAddress = detailAddress;
		this.motive = motive;
		this.authority = authority;
	}
	
	
	public User(int num, String name, String studentID, String password, String department, String email,
			String address, String detailAddress, Date date, String motive, String authority) {
		this.num = num;
		this.name = name;
		this.studentID = studentID;
		this.password = password;
		this.department = department;
		this.email = email;
		this.address = address;
		this.detailAddress = detailAddress;
		this.date = date;
		this.motive = motive;
		this.authority = authority;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", studentID=" + studentID + ", password=" + password
				+ ", department=" + department + ", email=" + email + ", address=" + address + ", detailAddress="
				+ detailAddress + ", date=" + date + ", motive=" + motive + ", authority=" + authority + "]";
	}
}
