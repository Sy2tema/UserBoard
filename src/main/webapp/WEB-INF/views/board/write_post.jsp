<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 글쓰기</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>새 글쓰기</h2>
	<form id="form1" name="form1" method="post" action="${ path }/board/insert.do">
		<div>
			<span>제목</span>
			<input name="title" id="title" size="79" placeholder="제목을 입력해주세요" />
		</div>
		<div style="width: 800px;">
			<span>내용</span>
			<textarea name="content" id="content" rows="3" cols="80" placeholder="내용을 입력해주세요"></textarea>
		</div>
		<div>
			<div>첨부파일</div>
			<div class="fileDrop"></div>
			<div id="uploadedList"></div>
		</div>
		<div style="width: 700px; text-align: center;">
			<button type="button" id="saveButton">글 등록</button>
		</div>
	</form>
</body>
</html>