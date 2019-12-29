package com.tistory.codingtrainee.model.dao;

import java.util.List;

import com.tistory.codingtrainee.model.dto.MemberDTO;

//Data Access Object로 Database내의 데이터에 접근하기 위한 인터페이스를 선언한다
public interface MemberDAO {
	public List<MemberDAO> memberList();
	
	public void insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	
	public boolean checkPwd(String userid, String password);
}
