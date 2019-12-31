package com.tistory.codingtrainee.model.dto;

import java.util.Date;

public class UserDTO {
	private String userid;
	private String password;
	private String username;
	private String email;
	private Date signup_date;
	
	// 비밀번호를 변경할 때 사용할 변수
	private String newpassword;
	private String checkpassword;
	
	public UserDTO() {
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
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	public String getCheckpassword() {
		return checkpassword;
	}
	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
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