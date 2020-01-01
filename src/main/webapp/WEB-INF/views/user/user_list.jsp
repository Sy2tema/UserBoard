<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 관리 페이지</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>회원 목록</h2>
	<table border="1" width="600px">
		<tr class="prop">
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입 일자</td>
		</tr>
		<!-- 모델에 저장했던 유저 리스트를 items속성을 통해 불러온다 -->
		<c:forEach var="row" items="${ list }">
			<tr>
				<td>${ row.userid }</td>
				<td>
					<a href="${ path }/user/view.do?userid=${ row.userid }">${ row.username }</a>
				</td>
				<td>${ row.email }</td>
				<td>
					<fmt:formatDate value="${ row.signup_date }" 
						pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 페이지를 넘어갈 때는 .jsp대신 .do를 해주어야 한다. 단, WEB-INF바깥에 위치한 파일을 불러오고자 한다면 .jsp를 유지해도 무방하다 -->
	<input type="button" value="새 회원 등록" style="margin-top: 10px; margin-left: 10px;"
		onclick="location.href='${ path }/user/signup.do'" />
</body>
</html>