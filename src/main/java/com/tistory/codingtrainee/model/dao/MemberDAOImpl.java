package com.tistory.codingtrainee.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tistory.codingtrainee.model.dto.MemberDTO;

// 인터페이스를 실제로 구현하는 클래스
// Repository어노테이션을 통해 DAO bean으로 등록시켜 Spring이 자동으로 객체 생성을 관리하도록 만들어줄 수 있다
// 이 어노테이션을 넣어주지 않으면 new를 통해 직접 객체를 생성해주어야 한다
@Repository
public class MemberDAOImpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// SqlSession객체를 개발자가 직접 생성하지 않고 스프링에서 생성시킨 후 주입시킨다
	// 이 과정은 DI(의존관계 주입)과정이라고 부른다
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> memberList() {
		logger.info("memberList()메소드가 호출되었습니다.");
		
		// sql mapper에 작성된 sql코드가 실행된다(auto commit and close)
		// member.memberList에서 앞은 namespace, 뒤는 id가 된다
		return sqlSession.selectList("member.memberList");
	}

	// 데이터베이스로 쿼리문을 보낼 때 commit()이나 close()를 할 필요가 없다 (자동으로 진행됨)
	@Override
	public void insertMember(MemberDTO vo) {
		// memberMapper.xml에 등록된 쿼리문을 호출한다
		sqlSession.insert("member.insertMember", vo);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}
	
	@Override
	public void updateMember(MemberDTO vo) {
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
