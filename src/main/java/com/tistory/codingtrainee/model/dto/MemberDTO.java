package com.tistory.codingtrainee.model.dto;

import java.util.Date;

public class MemberDTO {
	private String userid;
	private String password;
	private String username;
	private String email;
	private Date signup_date;
	
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

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSignup_date() {
		return signup_date;
	}
	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid = " + userid + ", password = " + password + ", username = " + username + ", email = " + email
				+ ", join_date = " + signup_date + "]";
	}
}