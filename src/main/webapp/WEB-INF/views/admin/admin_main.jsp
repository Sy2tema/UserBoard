<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 홈 화면</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/admin_menu.jsp" %>
	<c:if test="${ message == 'success' }">
		<h2>
			${ sessionScope.admin_username } (${ sessionScope.admin_userid }) 님의 방문을 환영합니다.
		</h2>
	</c:if>
</body>
</html>