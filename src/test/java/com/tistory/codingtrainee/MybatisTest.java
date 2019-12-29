package com.tistory.codingtrainee;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
// SpringJUnit4ClassRunner는 자바가 자동으로 검색해주지 않는 경향이 많기 때문에 조심하는 것이 좋다.
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit으로 실행시킨다.
@RunWith(SpringJUnit4ClassRunner.class)

// mybatis에서 참조할 설정파일의 위치 지정
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

// root-context.xml의 설정 파일이 잘 설정되었는지 확인해보는 클래스
public class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	// 의존관계를 설정한다 (Spring에서 객체를 생성 후 전달해줌)
	// root-context파일에서 이미 생성되어 있는 객체다.
	// @AutoWired어노테이션으로도 동일한 효과를 얻을 수 있다.
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		logger.info("sqlFactory : " + sqlFactory);
	}
	
	@Test
	public void testSession() {
		// mybatis의 실행을 위한 SqlSession객체 생성
		try (SqlSession session = sqlFactory.openSession()) {
			logger.info("sqlSession : " + session);
			logger.info("mybatis를 연결하는데 성공했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
