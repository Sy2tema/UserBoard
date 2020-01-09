package com.tistory.codingtrainee.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.user.dto.UserDTO;
import com.tistory.codingtrainee.service.admin.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Inject
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(UserDTO dto, HttpSession session, ModelAndView modelView) {
		String name = adminService.loginCheck(dto);
		
		if (name != null) {
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_username", dto.getUsername());
			
			modelView.setViewName("admin/admin_main");
			modelView.addObject("message", "success");
		} else {
			modelView.setViewName("admin/login");
			modelView.addObject("message", "error");
		}
		
		return modelView;
	}
}
