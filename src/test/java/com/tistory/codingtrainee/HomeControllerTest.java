package com.tistory.codingtrainee;

import static org.junit.Assert.*;

import org.junit.Test;

//뒤에 Test가 붙어있다면 해당 클래스를 테스트하고자 하는 클래스임을 알 수 있다.
public class HomeControllerTest {

	//JUnit을 사용해 테스트를 자동화하게 된다.
	@Test
	public void testHome() {
		System.out.println("testHome() 메소드가 실행되었습니다.");
	}

}
