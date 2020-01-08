package com.tistory.codingtrainee.service.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

// DAO와 별도로 Service를 구현하지 않는 경우도 있다 
public interface UserService {
	public List<UserDTO> userList();
	
	public void insertUser(UserDTO dto);
	public UserDTO viewUser(String userid);
	public void updateUser(UserDTO dto);
	public void deleteUser(String userid);
	
	// HttpSession으로 사용자 인증 정보를 처리할 수 있다
	public String loginCheck(UserDTO dto, HttpSession session);
	
	public boolean pwdCheck(String userid, String password);
}
