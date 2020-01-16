package com.tistory.codingtrainee.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void deleteFile(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> attachList(int boardingnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String filename, int boardingnumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writePost(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public BoardDTO readPost(int boardingnumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePost(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePost(int boardingnumber) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> postList(int startpage, int endpage, String searchoption, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("searchoption", searchoption);
		map.put("keyword", keyword);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		
		return sqlSession.selectList("board.postList", map);
	}

	@Override
	public void increaseViewCount(int boardingnumber) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int articleCount(String searchoption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
