package com.tistory.codingtrainee.controller.user;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.user.dto.UserDTO;
import com.tistory.codingtrainee.service.admin.AdminService;
import com.tistory.codingtrainee.service.user.UserService;

@Controller
@RequestMapping("/user/*") // 공통 url을 미리 매핑해둔다
public class UserController {
	// 의존관계를 주입시켜주는 것은 Spring에서 아주 중요하다
	@Inject
	UserService userService;
	
	@Inject
	AdminService adminService;
	
	@RequestMapping("list.do")
	public String userList(Model model) {		
		List<UserDTO> list = userService.userList();
		model.addAttribute("list", list);
		
		// 출력 페이지로 포워딩시킨다
		return "user/user_list";
	}
	
	// .do를 사용하고자 한다면 반드시 Controller에서 해당 작업을 실제로 실행하는 코드를 넣어주어야 정상 작동된다
	@RequestMapping("signup.do")
	public String signup(Model model) {
		return "user/signup";
	}
	
	// Spring에서는 POST방식으로 데이터를 전송하더라도 DTO클래스를 생성해 자동으로 해당 데이터들을 수집하게 된다
	// 이는 또한 request.getParameter()메소드를 사용하지 않아도 됨을 의미한다
	// ModelAttribute어노테이션이 앞에 붙어있는 변수가 있다면 해당 변수는 form에서 넘어오는 데이터 전체(DTO)를 저장하는 역할을 한다는 의미를 가지게 된다
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute UserDTO dto, Model model) {
		String userId = dto.getUserid();
		String password = dto.getPassword();
		String passwordCheck = dto.getCheckpassword();
		String userName = dto.getUsername();
		String email = dto.getEmail();
		
		// 처음에는 dto에 값을 넣어 다시 포워딩했을 때 뷰 부분에 해당 데이터들이 반영되지 않는 문제가 있었지만
		// 확인 결과 input태그 부분에 value로서 dto.<...>를 넣어주지 않아 포워딩한 값이 저장되지 않으며 발생했던 문제였음을 찾을 수 있었다. 
		if (!password.equals("") && !password.equals(passwordCheck)) {
			dto.setUserid(userId);
			dto.setUsername(userName);
			dto.setEmail(email);
			
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 확인되지 않았습니다.");
			
			return "user/signup";
		}
		
		if (userId.equals("")) {
			dto.setPassword(password);
			dto.setUsername(userName);
			dto.setEmail(email);
			
			model.addAttribute("dto", dto);
			model.addAttribute("message", "아이디가 입력되지 않았습니다.");
			
			return "user/signup";
		} else if (password.equals("")) {
			dto.setUserid(userId);
			dto.setUsername(userName);
			dto.setEmail(email);
			
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 입력되지 않았습니다.");

			return "user/signup";
		} else if (userName.equals("")) {
			dto.setUserid(userId);
			dto.setPassword(password);
			dto.setEmail(email);
			
			model.addAttribute("dto", dto);
			model.addAttribute("message", "이름이 입력되지 않았습니다.");
			
			return "user/signup";
		} else if (email.equals("")) {
			dto.setUserid(userId);
			dto.setPassword(password);
			dto.setUsername(userName);
			
			model.addAttribute("dto", dto);
			model.addAttribute("message", "이메일이 입력되지 않았습니다.");
			
			return "user/signup";
		}
		
		// 관리자 계정과 같은 아이디로 가입하는 것을 방지하기 위한 부분
		String isAdmin = adminService.loginCheck(dto);
		
		if (isAdmin != null) {
			model.addAttribute("message", "해당 아이디로는 가입이 불가능합니다.");
			
			return "user/signup";
		}
		
		// 테이블에 레코드를 입력하는 코드
		userService.insertUser(dto);
					
		// 저장을 완료했으니 다시 회원가입 화면으로 돌아갈 이유가 없어지기 때문에 redirect를 통해 목록을 갱신시킨다
		return "redirect:/user/login.do";
	}
	
	// RequestParam어노테이션은 ModelAttribute어노테이션과는 달리 form에서 원하는 값만 저장할 수 있도록 만들어준다
	@RequestMapping("view.do")
	public String view(@RequestParam String userid, Model model) {
		// 서비스 클래스를 통해 찾아낸 해당 유저의 정보를 모델에 저장한다
		model.addAttribute("dto", userService.viewUser(userid));
		
		return "user/user_view";
	}
	
	@RequestMapping("update.do")
	public String update(@ModelAttribute UserDTO dto, Model model) {
		boolean isTrue = userService.pwdCheck(dto.getUserid(), dto.getPassword());
		String newPassword = dto.getNewpassword();
		String checkPassword = dto.getCheckpassword();
		UserDTO dto2;
		
		// 입력했던 비밀번호와 일치할 경우에만 정보를 수정한다
		if (isTrue) {
			if (!newPassword.equals("") && !checkPassword.equals("")) {
				if (newPassword.equals(checkPassword)) {
					dto.setPassword(newPassword);
				} else {
					dto2 = userService.viewUser(dto.getUserid());
					dto.setNewpassword("");
					dto.setCheckpassword("");
					dto.setSignupdate(dto2.getSignupdate());
					model.addAttribute("dto", dto);
					model.addAttribute("message", "새 비밀번호가 일치하지 않습니다.");
					
					return "user/user_view";
				}
			}
			
			userService.updateUser(dto);
			return "redirect:/user/list.do";
		} else {
			// 따로 처리하지 않으면 기존 정보들이 사라지기 때문에 이를 방지했다
			dto2 = userService.viewUser(dto.getUserid());
			dto.setNewpassword("");
			dto.setCheckpassword("");
			dto.setSignupdate(dto2.getSignupdate());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			
			return "user/user_view";
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam String userid, String password, Model model) {
		boolean isTrue = userService.pwdCheck(userid, password);
		
		if (isTrue) {
			userService.deleteUser(userid);
			return "redirect:/user/list.do";
		} else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", userService.viewUser(userid));
			
			return "user/user_view";
		}
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute UserDTO dto, HttpSession session) {
		String name = userService.loginCheck(dto, session);
		ModelAndView modelView = new ModelAndView();
		
		// 로그인에 실패할 경우 null이 저장된다
		if (name != null) {
			modelView.setViewName("main");
		} else {
			modelView.setViewName("user/login");
			modelView.addObject("message", "error");
		}
		
		return modelView;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView modelView) {
		// 현재 세션에 저장되어 있는 값을 모두 비운다
		session.invalidate();
		
		// 이동할 페이지를 선택 후 해당 변수에 값을 저장해 함께 푸시한다
		modelView.setViewName("user/login");
		modelView.addObject("message", "logout");
		
		return modelView;
	}
}
