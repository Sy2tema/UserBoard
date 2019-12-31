package com.tistory.codingtrainee.model.dao;

import java.util.List;

import com.tistory.codingtrainee.model.dto.UserDTO;

//Data Access Object로 Database내의 데이터에 접근하기 위한 인터페이스를 선언한다
public interface UserDAO {
	public List<UserDTO> userList();
	
	public void insertUser(UserDTO vo);
	public UserDTO viewUser(String userid);
	public void updateUser(UserDTO vo);
	public void deleteUser(String userid);
	
	public boolean checkPwd(String userid, String password);
}
