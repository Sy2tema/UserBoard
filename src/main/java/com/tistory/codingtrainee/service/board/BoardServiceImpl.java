package com.tistory.codingtrainee.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tistory.codingtrainee.model.board.dao.BoardDAO;
import com.tistory.codingtrainee.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDao;
	
	@Override
	public void deleteFile(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> attachList(int boardingNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String filename, int boardingNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writePost(BoardDTO dto) throws Exception {
		boardDao.writePost(dto);
	}

	@Override
	public BoardDTO readPost(int boardingNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePost(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePost(int boardingNumber) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> postList(int startPage, int endPage, String searchOption, String keyword) throws Exception {
		return boardDao.postList(startPage, endPage, searchOption, keyword);
	}

	@Override
	public void increaseViewCount(int boardingNumber) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int articleCount(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
