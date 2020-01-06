package com.tistory.codingtrainee.service.board;

import java.util.List;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;

public interface BoardService {
	//첨부파일 삭제 메소드
	public void deleteFile(String fileName);
	//첨부파일 목록확인 메소드
	public List<String> attachList(int boardingNumber);
	//첨부파일 저장 메소드
	public void addAttach(String fileName);
	public void updateAttach(String filename, int boardingNumber);
	public void writePost(BoardDTO dto) throws Exception;
	public BoardDTO readPost(int boardingNumber) throws Exception;
	public void updatePost(BoardDTO dto) throws Exception;
	public void removePost(int boardingNumber) throws Exception;
	//목록 기능 메소드
	public List<BoardDTO> postList(int start, int end, String searchOption, String keyword) throws Exception;
	//조회수 증가 메소드
	public void increaseViewCount(int boardingNumber) throws Exception;
	//레코드 개수 계산 메소드
	public int articleCount(String searchOption, String keyword) throws Exception;
}
