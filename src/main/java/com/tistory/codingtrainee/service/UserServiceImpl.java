package com.tistory.codingtrainee.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.model.dao.UserDAO;
import com.tistory.codingtrainee.model.dto.UserDTO;

// DAO와는 달리 구현 단계에서 Service어노테이션을 사용한다는 차이가 있다
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	// Spring컨테이너가 자동으로 dao객체와 연결시켜준다 (의존관계)
	@Inject
	UserDAO userDao;

	@Override
	public List<UserDTO> userList() {
		return userDao.userList();
	}

	@Override
	public void insertUser(UserDTO dto) {
		userDao.insertUser(dto);
	}

	@Override
	public UserDTO viewUser(String userid) {
		// DAO로부터 viewuser를 호출해 받은 DTO를 Controller로 옮긴다
		return userDao.viewUser(userid);
	}

	@Override
	public void updateUser(UserDTO dto) {
		userDao.updateUser(dto);
	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPwd(String userid, String password) {
		return userDao.checkPwd(userid, password);
	}

}