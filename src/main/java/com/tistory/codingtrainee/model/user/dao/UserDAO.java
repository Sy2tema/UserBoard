package com.tistory.codingtrainee.model.user.dao;

import java.util.List;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

//Data Access Object로 Database내의 데이터에 접근하기 위한 인터페이스를 선언한다
public interface UserDAO {
	public List<UserDTO> userList();
	
	public void insertUser(UserDTO dto);
	public UserDTO viewUser(String userid);
	public void updateUser(UserDTO dto);
	public void deleteUser(String userid);
	
	public String loginCheck(UserDTO dto);
	public String adminLoginCheck(UserDTO dto);
	public boolean pwdCheck(String userid, String password);
}
