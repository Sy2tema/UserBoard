package com.tistory.codingtrainee.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;
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
		map.put("list", list);
		modelView.addObject("map", map);
		
		return modelView;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write_post";
	}
	
	// DB에 입력된 글을 저장해주는 메소드
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) throws Exception {
		// 현재 로그인중인 사용자의 아이디값을 입력받는다
		String writer = (String)session.getAttribute("userid");
		// TODO : 로그인되지 않은 상태에서는 로그인 화면으로 넘어가도록 조치한다
		dto.setWriter(writer);
		// 레코드를 저장시킨다
		boardService.writePost(dto);
		
		// 게시판의 내용을 갱신시킨다
		return "redirect:/board/list.do";
	}
}