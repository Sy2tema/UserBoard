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
	<form id="form1" name="form1" metdod="post" action="${ patd }/board/insert.do">
		<table width="450px" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="2" align="center" width="100%"><div class="title">새 글</div></td>
				</tr>
			</thead>
			<tr>
				<td width="20%"><div>제목</div></td>
				<td width="80%"><input name="title" id="title" placeholder="제목을 입력해주세요" /></td>
			</tr>
			<tr>
				<td width="20%"><div>내용</div></td>
				<td width="80%"><textarea name="content" id="content" rows="3" cols="80" placeholder="내용을 입력해주세요"></textarea></td>
			</tr>
			<tr>
				<td width="30%"><div>첨부파일</div></td>
				<td width="70%"	>
					<div class="fileDrop"></div>
					<div id="uploadedList"></div>
				</td>
			</tr>
		</table>
		<div style="width: 700px; text-align: center;">
			<button type="button" id="saveButton">글 등록</button>
		</div>
	</form>
</body>
</html>