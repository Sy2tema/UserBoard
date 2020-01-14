package com.tistory.codingtrainee.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;
import com.tistory.codingtrainee.model.user.dto.UserDTO;
import com.tistory.codingtrainee.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;
	
	// 글 목록 보기
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<BoardDTO> list = boardService.postList(0, 0, "", "");
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("board/board_list"); //이동 페이지를 지정한다
		Map<String, Object> map = new HashMap<>(); //데이터 저장
		map.put("list", list); // 읽어들인 리스트의 값들을 map에 넣어준다
		modelView.addObject("map", map);
		
		return modelView;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write_post";
	}
	
	// 글 쓰기
	@RequestMapping("create.do")
	public String create(@ModelAttribute BoardDTO dto, HttpSession session) {
		// 현재 로그인한 사용자의 이름을 받는다
		// 로그인의 여부는 인터셉터를 이용해서 처리하도록 한다
		String writer = (String) session.getAttribute("name");
	
		
		dto.setWriter(writer);
		
		try {
			// 레코드를 저장한다
			boardService.writePost(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/board/list.do";
	}
}