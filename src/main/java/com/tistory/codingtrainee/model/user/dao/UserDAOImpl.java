package com.tistory.codingtrainee.model.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

// 인터페이스를 실제로 구현하는 클래스
// Repository어노테이션을 통해 DAO bean으로 등록시켜 Spring이 자동으로 객체 생성을 관리하도록 만들어줄 수 있다
// 이 어노테이션을 넣어주지 않으면 new를 통해 직접 객체를 생성해주어야 한다
@Repository
public class UserDAOImpl implements UserDAO {
	// SqlSession객체를 개발자가 직접 생성하지 않고 스프링에서 생성시킨 후 주입시킨다
	// 이 과정은 DI(의존관계 주입)과정이라고 부른다
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<UserDTO> userList() {
		// sql mapper에 작성된 sql코드가 실행된다(auto commit and close)
		// user.userList에서 앞은 namespace, 뒤는 id가 된다
		return sqlSession.selectList("user.userList");
	}

	// 데이터베이스로 쿼리문을 보낼 때 commit()이나 close()를 할 필요가 없다 (자동으로 진행됨)
	@Override
	public void insertUser(UserDTO dto) {
		// userMapper.xml에 등록된 쿼리문을 호출한다
		sqlSession.insert("user.insertUser", dto);
	}

	@Override
	public UserDTO viewUser(String userid) {
		// 레코드가 두개 이상이면 selectList()메소드를 사용한다
		return sqlSession.selectOne("user.viewUser", userid);
	}
	
	@Override
	public void updateUser(UserDTO dto) {
		sqlSession.update("user.updateUser", dto);
	}

	@Override
	public void deleteUser(String userid) {
		sqlSession.delete("user.deleteUser", userid);
	}

	@Override
	public String loginCheck(UserDTO dto) {
		return sqlSession.selectOne("user.loginCheck", dto);
	}
	
	@Override
	public String adminLoginCheck(UserDTO dto) {
		return sqlSession.selectOne("admin.loginCheck", dto);
	}
	
	@Override
	public boolean pwdCheck(String userid, String password) {
		// 쿼리에 id와 비밀번호 두 개의 값을 보내야 하기 때문에 map으로 묶었다
		Map<String, String> map = new HashMap<>();
		
		map.put("userid", userid);
		map.put("password", password);
		
		int count = sqlSession.selectOne("user.pwdCheck", map);
		
		// count가 1이면 비밀번호가 일치함을 뜻한다.
		return count == 1 ? true : false;
	}

}
