package com.tistory.codingtrainee.service.user;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.model.user.dao.UserDAO;
import com.tistory.codingtrainee.model.user.dto.UserDTO;

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
		userDao.deleteUser(userid);
	}

	@Override
	public String loginCheck(UserDTO dto, HttpSession session) {
		String name = userDao.loginCheck(dto);
		
		// 로그인에 성공했을 시
		if (name != null) {
			// 세션변수에 값을 등록한다
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		
		return name;
	}
	
	@Override
	public boolean pwdCheck(String userid, String password) {
		return userDao.pwdCheck(userid, password);
	}

}
