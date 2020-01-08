package com.tistory.codingtrainee.model.admin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public String loginCheck(UserDTO dto) {
		return sqlSession.selectOne("admin.loginCheck", dto);
	}

}
