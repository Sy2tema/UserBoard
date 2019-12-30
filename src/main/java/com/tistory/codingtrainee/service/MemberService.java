package com.tistory.codingtrainee.service;

import java.util.List;

import com.tistory.codingtrainee.model.dto.MemberDTO;

// DAO와 별도로 Service를 구현하지 않는 경우도 있다 
public interface MemberService {
	public List<MemberDTO> memberList();
	
	public void insertMember(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String userid);
	
	public boolean checkPwd(String userid, String password);
}
