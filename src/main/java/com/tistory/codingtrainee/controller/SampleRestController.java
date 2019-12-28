package com.tistory.codingtrainee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.codingtrainee.model.dto.ProductDTO;

// AJax전용 컨트롤러로 백그라운드에서 실행되며 Spring 4.0부터 사용이 가능한 어노테이션이다
// 3.xx버전의 경우에는 일반적인 Controller를 사용하면 되며 본문에 ResponseBody를 추가적으로 붙여줘야 한다
@RestController
public class SampleRestController {
	// ResponseBody어노테이션은 JSON형식으로 데이터를 리턴하겠다는 뜻을 가지고 있다
	// @ResponseBody
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("냉장고", 1500000);
	}
}
