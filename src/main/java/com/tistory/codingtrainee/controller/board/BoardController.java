package com.tistory.codingtrainee.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;
import com.tistory.codingtrainee.service.board.BoardPager;
import com.tistory.codingtrainee.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;
	
	// 조건에 따라 검색한 글 목록 보기 
	// RequestParam어노테이션을 사용할 때 defaultValue를 설정해주지 않을 경우 NullPointerException이나 400에러가 발생할 수 있다
	@RequestMapping("list.do")
	public ModelAndView list(
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		// 검색 조건을 활용해 해당하는 레코드의 개수를 계산한 결과를 받는 변수
		int count = boardService.articleCount(searchOption, keyword);
		
		BoardPager pager = new BoardPager(count, currentPage);
		
		// 쿼리문에서 where rownumber between A and B의 A와 B의 값을 계산해 저장한 변수
		int startPage = pager.getPageBegin();
		int endPage = pager.getPageEnd();
		
		List<BoardDTO> list = boardService.postList(startPage, endPage, searchOption, keyword);
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("board/board_list"); //이동 페이지를 지정한다
		
		Map<String, Object> map = new HashMap<>(); //데이터 저장
		map.put("list", list); // 읽어들인 리스트의 값들을 map에 넣어준다
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("pager", pager);
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
		// 현재 로그인한 사용자의 이름을 받는
		// 로그인의 여부는 인터셉터를 이용해서 처리하도록 한다
		String writer = (String) session.getAttribute("userid");
	
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