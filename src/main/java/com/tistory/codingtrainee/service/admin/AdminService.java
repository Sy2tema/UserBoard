package com.tistory.codingtrainee.service.admin;

import javax.servlet.http.HttpSession;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

public interface AdminService {
	public String loginCheck(UserDTO dto);
}
