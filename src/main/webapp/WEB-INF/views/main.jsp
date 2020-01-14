<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" charset="UTF-8">
	<title>메인 화면</title>
	<%@ include file="include/header.jsp" %>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<div style="margin-top: 10rem">
		<c:choose>
			<c:when test="${ sessionScope.userid != null }">
				<h2>UserBoard프로젝트의 홈 화면입니다.</h2>
				<h2>
					${ sessionScope.username } (${ sessionScope.userid }) 님의 방문을 환영합니다.
				</h2>
			</c:when>
			<c:otherwise>
				<h2><a href="admin/login.do" 
						style="
							color: black; 
							text-decoration: none;
							cursor: default;
					"> <!-- 관리자 로그인 창을 숨기기 위한 추가 css속성 등록 -->
						UserBoard프로젝트의 홈 화면입니다.
					</a>
				</h2>
				<h2>${ message }</h2>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>