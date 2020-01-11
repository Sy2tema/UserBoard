package com.tistory.codingtrainee.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.user.dto.UserDTO;
import com.tistory.codingtrainee.service.admin.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	// 일반적인 문자열 형식으로 반환 시 제대로 관리자 이름과 아이디가 뷰에 출력되지 않아 ModelAndView로 반환하도록 조치했다
	@RequestMapping("admin_main.do")
	public ModelAndView main(ModelAndView modelView) {
		modelView.setViewName("admin/admin_main");
		modelView.addObject("message", "success");
		
		return modelView;
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(UserDTO dto, HttpSession session, ModelAndView modelView) {
		String name = adminService.loginCheck(dto);
		
		if (name != null) {
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("username", name);
			modelView.setViewName("admin/admin_main");
			modelView.addObject("message", "success");
		} else {
			modelView.setViewName("admin/login");
			modelView.addObject("message", "error");
		}
		
		return modelView;
	}
}
