package com.tistory.codingtrainee.domain;

import java.util.Date;

// Oracle에서 생성한 테이블에 대한 VO가 작성되는 클래스
public class BoardVO {
	String userid, password, username, email;
	Date signup_date;
	
	// lombok라이브러리를 통해 어노테이션만 작성하는 방식을 사용할 수도 있다.
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
}
