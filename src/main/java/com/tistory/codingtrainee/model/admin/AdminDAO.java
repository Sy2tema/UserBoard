package com.tistory.codingtrainee.model.admin;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

public interface AdminDAO {
	public String loginCheck(UserDTO dto);
}
