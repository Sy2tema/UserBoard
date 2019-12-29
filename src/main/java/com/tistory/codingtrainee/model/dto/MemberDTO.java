package com.tistory.codingtrainee.model.dto;

import java.util.Date;

public class MemberDTO {
	private String userid;
	private String password;
	private String name;
	private String email;
	private Date join_date;
	
	public MemberDTO() {
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid = " + userid + ", password = " + password + ", name = " + name + ", email = " + email
				+ ", join_date = " + join_date + "]";
	}
}