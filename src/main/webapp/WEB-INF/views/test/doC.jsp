<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ModelAndView테스트</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>상품명 : ${ map.product.name }</h2>
	<h2>가격 : ${ map.product.price }원</h2>
</body>
</html>