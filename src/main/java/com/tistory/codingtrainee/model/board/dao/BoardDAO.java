package com.tistory.codingtrainee.model.board.dao;

import java.util.List;

import com.tistory.codingtrainee.model.board.dto.BoardDTO;

public interface BoardDAO {
	//첨부파일 삭제 메소드
	public void deleteFile(String filename);
	//첨부파일 목록확인 메소드
	public List<String> attachList(int boardingnumber);
	//첨부파일 저장 메소드
	public void addAttach(String fileName);
	public void updateAttach(String filename, int boardingnumber);
	public void writePost(BoardDTO dto) throws Exception;
	public BoardDTO readPost(int boardingnumber) throws Exception;
	public void updatePost(BoardDTO dto) throws Exception;
	public void removePost(int boardingnumber) throws Exception;
	//목록 기능 메소드
	public List<BoardDTO> postList(int start, int end, String searchoption, String keyword) throws Exception;
	//조회수 증가 메소드
	public void increaseViewCount(int boardingnumber) throws Exception;
	//레코드 개수 계산 메소드
	public int articleCount(String searchoption, String keyword) throws Exception;
}
