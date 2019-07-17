package com.my.entity;

import java.util.Date;

public class Student {
	private int sid;
	private String sname;
	private String  gender;
	private Date  birthday;
	private int  cid;
	private Classes cla;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Classes getCla() {
		return cla;
	}
	public void setCla(Classes cla) {
		this.cla = cla;
	}
	public Student() {
	}
	public Student(String sname, String gender, Date birthday , int cid) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.cid = cid;
	}
	public Student(int sid, String sname, String gender, Date birthday) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday + ", cid="
				+ cid + ", cla=" + cla + "]";
	}

	
	
}
