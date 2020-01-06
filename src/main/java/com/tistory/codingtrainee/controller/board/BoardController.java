package com.tistory.codingtrainee.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;
import com.tistory.codingtrainee.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService BoardService;
	
	//글 목록 보기
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<BoardDTO> list = BoardService.postList(0, 0, "", "");
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("board/board_list"); //이동 페이지를 지정한다
		Map<String, Object> map = new HashMap<>(); //데이터 저장
		map.put("list", list);
		modelView.addObject("map", map);
		
		return modelView;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write_post";
	}
}