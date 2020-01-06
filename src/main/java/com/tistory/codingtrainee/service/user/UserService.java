package com.tistory.codingtrainee.service.user;

import java.util.List;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

// DAO와 별도로 Service를 구현하지 않는 경우도 있다 
public interface UserService {
	public List<UserDTO> userList();
	
	public void insertUser(UserDTO dto);
	public UserDTO viewUser(String userid);
	public void updateUser(UserDTO dto);
	public void deleteUser(String userid);
	
	public boolean checkPwd(String userid, String password);
}
