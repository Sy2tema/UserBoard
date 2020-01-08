package com.tistory.codingtrainee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// 홈으로 이동하기
	// Model은 데이터를 담는 그릇으로 map구조로 이루어져 있다.
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("message", "페이지 방문을 환영합니다.");
		// servlet-context.xml을 통해 미리 문자열을 입력해놓은 결과 아래와 같은 반환값을 작성해도
		// /WEB-INF/views/<리턴값>.jsp로 이루어진 결과를 얻을 수 있다.
		return "main";
	}
}
