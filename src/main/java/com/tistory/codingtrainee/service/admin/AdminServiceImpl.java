package com.tistory.codingtrainee.service.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.model.admin.AdminDAO;
import com.tistory.codingtrainee.model.user.dto.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	AdminDAO adminDao;	
	
	@Override
	public String loginCheck(UserDTO dto) {
		return adminDao.loginCheck(dto);
	}
}
