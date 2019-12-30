package com.tistory.codingtrainee.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.model.dao.MemberDAO;
import com.tistory.codingtrainee.model.dto.MemberDTO;

// DAO와는 달리 구현 단계에서 Service어노테이션을 사용한다는 차이가 있다
@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// Spring컨테이너가 자동으로 dao객체와 연결시켜준다 (의존관계)
	@Inject
	MemberDAO memberDao;

	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPwd(String userid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
