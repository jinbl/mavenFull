package com.my.entity;

import java.util.List;

/**
* @类名  Class.java
* @作者  jinbanglong
* @版本  V1.0
* @日期  2019年7月13日-下午3:51:27
* @描述  
*
*/
public class Classes {
	private int cid;
	private String cname;
	private List<Student> list;
	public Classes() {
	}
	public Classes(String cname) {
		this.cname = cname;
	}
	public Classes(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", list=" + list + "]";
	}
	
}
