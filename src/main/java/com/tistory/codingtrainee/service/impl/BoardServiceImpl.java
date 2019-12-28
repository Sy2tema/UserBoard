package com.tistory.codingtrainee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.domain.BoardVO;
import com.tistory.codingtrainee.mapper.BoardMapper;
import com.tistory.codingtrainee.service.BoardService;

// BoardService인터페이스를 실제로 구현하는 클래스
@Service
public class BoardServiceImpl implements BoardService {
	// 의존성 주입을 위한 어노테이션
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> viewAll() {
		return mapper.viewAll();
	}
}