package com.tistory.codingtrainee.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tistory.codingtrainee.model.dto.UserDTO;
import com.tistory.codingtrainee.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// 의존관계를 주입시켜주는 것은 Spring에서 아주 중요하다
	@Inject
	UserService userService;
	
	@RequestMapping("user/list.do")
	public String userList(Model model) {		
		List<UserDTO> list = userService.userList();
		logger.info("회원 목록 : " + list);
		model.addAttribute("list", list);
		
		// 출력 페이지로 포워딩시킨다
		return "user/user_list";
	}
	
	// .do를 사용하고자 한다면 반드시 Controller에서 해당 작업을 실제로 실행하는 코드를 넣어주어야 정상 작동된다
	@RequestMapping("user/signup.do")
	public String signup(Model model) {
		logger.info("signup()메소드가 호출되었습니다.");
		return "user/signup";
	}
	
	// Spring에서는 POST방식으로 데이터를 전송하더라도 DTO클래스를 생성해 자동으로 해당 데이터들을 수집하게 된다
	// 이는 또한 request.getParameter()메소드를 사용하지 않아도 됨을 의미한다
	// ModelAttribute어노테이션이 앞에 붙어있는 변수가 있다면 해당 변수는 form에서 넘어오는 데이터 전체(DTO)를 저장하는 역할을 한다는 의미를 가지게 된다
	@RequestMapping("user/insert.do")
	public String insert(@ModelAttribute UserDTO dto) {
		// 테이블에 레코드를 입력하는 코드
		userService.insertUser(dto);		
		
		// 저장을 완료했으니 다시 회원가입 화면으로 돌아갈 이유가 없어지기 때문에 redirect를 통해 목록을 갱신시킨다
		return "redirect:/user/list.do";
	}
	
	// RequestParam어노테이션은 ModelAttribute어노테이션과는 달리 form에서 원하는 값만 저장할 수 있도록 만들어준다
	@RequestMapping("user/view.do")
	public String view(@RequestParam String userid, Model model) {
		logger.info("조회한 회원 아이디 : " + userid);
		
		// 서비스 클래스를 통해 찾아낸 해당 유저의 정보를 모델에 저장한다
		model.addAttribute("dto", userService.viewUser(userid));
		
		return "user/user_view";
	}
	
	@RequestMapping("user/update.do")
	public String update(@ModelAttribute UserDTO dto, Model model) {
		logger.info("update()메소드가 호출되었습니다. " + dto.getUserid());
		boolean isTrue = userService.checkPwd(dto.getUserid(), dto.getPassword());
		logger.info("" + isTrue);
		
		// 입력했던 비밀번호와 일치할 경우에만 정보를 수정한다
		if (isTrue) {
			userService.updateUser(dto);
			return "redirect:/user/list.do";
		} else {
			// 따로 처리하지 않으면 기존 정보들이 사라지기 때문에 이를 방지했다
			UserDTO dto2 = userService.viewUser(dto.getUserid());
			dto.setSignup_date(dto2.getSignup_date());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "user/view";
		}
	}
	
}
