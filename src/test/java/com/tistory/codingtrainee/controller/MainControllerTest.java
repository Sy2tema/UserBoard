package com.tistory.codingtrainee.controller;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// JUnit4로 테스트하겠다는 의미를 가지고 있다
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일의 경로를 지정한다
@WebAppConfiguration
@ContextConfiguration(
	locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MainControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class); 
	
	// 의존관계를 주입한다
	// MockMvc를 이용해 가상으로 컨트롤러를 테스트하기 위한 객체를 선언해준다
	@Inject
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	// 테스트 전에 호출되는 코드
	// 테스트 후에 호출되도록 After라는 어노테이션도 존재한다
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		System.out.println("setup prcess continue...");
	}

	@Test
	public void testDoA() throws Exception {
		// 뷰가 완전하지 않은 상태에서도 테스트가 가능하다
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doA"));
		logger.info("doA메소드를 불러옵니다...");
	}
}
