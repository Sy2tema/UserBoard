package com.tistory.codingtrainee.model.board.dto;

import java.util.Arrays;
import java.util.Date;

import com.tistory.codingtrainee.model.user.dto.UserDTO;

public class BoardDTO {
	private int boardingnumber;
	private String title;
	private String content;
	private String writer; //userboard테이블과 조인을 수행한다
	private Date boardingdate;
	private int rownum; //페이징을 위한 변수
	private int viewcount;
	private int commentcount; //댓글 개수
	private String isvisible; //화면 표시 여부
	private String[] files; //첨부 파일
	
	private UserDTO userDTO; //다른 테이블에서 조인해와 결과를 출력하려 할 때도 DTO에 해당 변수명을 정의해두어야 오류가 발생하지 않는다
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public int getBoardingnumber() {
		return boardingnumber;
	}
	public void setBoardingnumber(int boardingnumber) {
		this.boardingnumber = boardingnumber;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getBoardingdate() {
		return boardingdate;
	}
	public void setBoardingdate(Date boardingdate) {
		this.boardingdate = boardingdate;
	}
	
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	
	public String getIsvisible() {
		return isvisible;
	}
	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
	}
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardingnumber=" + boardingnumber + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", boardingdate=" + boardingdate + ", rownum=" + rownum + ", viewcount=" + viewcount
				+ ", commentcount=" + commentcount + ", isvisible=" + isvisible + ", files=" + Arrays.toString(files)
				+ ", userDTO=" + userDTO + "]";
	}
}