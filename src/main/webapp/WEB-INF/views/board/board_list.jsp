<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 페이지</title>
	<%@ include file="../include/header.jsp" %>
	<script>
		$(function () {
			$("#writeButton").click(function () {
				location.href="${ path }/board/write.do";
			});
		});
	</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>유저 게시판</h2>
	<button type="button" id="writeButton" style="margin-left: 10px; margin-bottom: 6px;">새 글</button>
	<table border="1" width="600px">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>작성자 이름</th>
			<th>작성 날짜</th>
			<th>조회수</th>		
		</tr>
		<c:forEach var="row" items="${ map.list }">
			<tr>
				<td>${ row.boardingnumber }</td>
				<td>${ row.title }</td>
				<td>${ row.writer }</td>
				<td><fmt:formatDate value="${ row.boardingdate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${ row.viewCount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>