<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 글쓰기</title>
	<%@ include file="../include/header.jsp" %>
	<script>
		$(function () {
			$("#saveButton").click(function () {
				document.form1.submit();
			});
		});
	</script>
	<style>
		td div {
			text-align: center;
			font-weight: bold;
		}
		table {
			 border-spacing: 0px 15px;
			 width: 600px;
			 border: 0;
		}
	</style>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<form id="form1" name="form1" metdod="post" action="${ path }/board/create.do">
		<table>
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
				<td width="80%"><textarea name="content" id="content" rows="5" cols="70" placeholder="내용을 입력해주세요"></textarea></td>
			</tr>
			<tr>
				<td width="20%"><div>첨부파일</div></td>
				<td width="80%">
					<div class="fileDrop"></div>
					<div id="uploadedList"></div>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="25%">
					<button type="button" class="button" id="saveButton">글 등록</button>
				</td>
				<td width="75%"></td>
			</tr>
		</table>
	</form>
</body>
</html>