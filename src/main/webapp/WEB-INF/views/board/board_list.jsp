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
		function list(page) {
			location.href = "${ path }/board/list.do?currentPage=" + page
				+ "&searchOption=${ map.searchOption }"
				+ "&keyword=${ map.keyword }";
		}
	</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<table width="600px" style="margin-top: 3rem; margin-bottom: 1rem;">
		<tr>
			<td class="title">
				유저 게시판
			</td>
		</tr>
	</table>
	<table border="1" width="600px" class="board">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="row" items="${ map.list }">
			<tr>
				<td>${ row.boardingnumber }</td>
				<td>${ row.title }</td>
				<td>${ row.username }</td>
				<td>${ row.viewcount }</td>
				<td><fmt:formatDate value="${ row.boardingdate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
		<!-- 글 검색하기 -->
		<tr style="border-bottom: 0;">
			<td colspan="5">
				<form name="form1" method="post" action="${ path }/board/list.do">
					<c:choose>
						<c:when test="${ map.searchOption == 'all' }">
							<select name="searchOption">
								<option value="all" selected>이름+내용+제목</option>
								<option value="writer">닉네임</option>
								<option value="content">내용</option>
								<option value="title">제목</option>
							</select>
						</c:when>
						<c:when test="${ map.searchOption == 'writer' }">
							<select name="searchOption">
								<option value="all">이름+내용+제목</option>
								<option value="writer" selected>닉네임</option>
								<option value="content">내용</option>
								<option value="title">제목</option>
							</select>
						</c:when>
						<c:when test="${ map.searchOption == 'content' }">
							<select name="searchOption">
								<option value="all">이름+내용+제목</option>
								<option value="writer">닉네임</option>
								<option value="content" selected>내용</option>
								<option value="title">제목</option>
							</select>
						</c:when>
						<c:when test="${ map.searchOption == 'title' }">
							<select name="searchOption">
								<option value="all">이름+내용+제목</option>
								<option value="writer">닉네임</option>
								<option value="content">내용</option>
								<option value="title" selected>제목</option>
							</select>
						</c:when>
					</c:choose>
					<input name="keyword" value="${ map.keyword }" />
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
		<!-- 페이지를 이동할 수 있도록 만들어주는 부분 -->
		<tr style="border-top: 0;">
			<td colspan="5" align="center">
				<c:if test="${ map.pager.currentBlock > 1}">
					<a href="javascript:list('1')">[first]</a>
				</c:if>
				<c:if test="${ map.pager.currentBlock > 1 }">
					<a href="javascript:list('${ map.pager.previousPage }')">[prev]</a>
				</c:if>
				<c:forEach var="number" begin="${ map.pager.blockBegin }" end="${ map.pager.blockEnd }">
					<c:choose>
						<c:when test="${ number == map.pager.currentPage }">
							<span style="color: darkred;">${ number }</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:list('${ number }')">${ number }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${ map.pager.currentBlock <= map.pager.totalBlock }">
					<a href="javascript:list('${ map.pager.nextPage }')">[next]</a>
				</c:if>
				<c:if test="${ map.pager.currentPage <= map.pager.totalPage }">
					<a href="javascript:list('${ map.pager.totalPage }')">[end]</a>
				</c:if>
			</td>
		</tr>
	</table>
	<c:if test="${ sessionScope.userid != null || sessionScope.admin_userid != null }">
		<table width="600px">
			<tr>
				<td width="20%">
					<button class="button" id="writeButton">새 글</button>
				</td>
				<td width="90%"></td>
			</tr>
		</table>
	</c:if>
	<div style="text-align: center; margin-top: 10px;">총 ${ map.count }개의 게시물이 있습니다.</div>
</body>
</html>