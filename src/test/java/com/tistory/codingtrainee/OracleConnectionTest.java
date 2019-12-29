package com.tistory.codingtrainee;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.slf4j.Logger;

public class OracleConnectionTest {
	// 로깅을 처리하기 위한 코드
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	// Oracle DB를 연결하기 위한 변수 등록 
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/sy2tema";
	private static final String USER = "spring";
	private static final String PWD = "1234";
	
	//JUnit을 이용해 테스트를 진행하게 되며 어노테이션을 통해 테스트할 코드를 알려준다.
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD)) {
			System.out.println("오라클과 연결에 성공하였습니다.");
			logger.info("오라클과 연결에 성공하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}