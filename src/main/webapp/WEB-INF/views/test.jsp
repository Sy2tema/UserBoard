<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포워딩 테스트</title>
	<%@ include file="include/header.jsp" %>
	<script>
		function doF() {
			// 비동기적인 방식으로 페이지는 변화하지 않고 데이터만 변경된다
			$.ajax({
				// Content Type은 "application/json"이다
				type: "post",
				url: "${path}/test/doF",
				success: function (result) {
					console.log(result);
					$("#result").html("상품명 : " + result.name + "\n가격 : " + result.price);
				}
			});
		}
	</script>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<h1>링크 포워딩 테스트</h1>
	<a href="${path}/test/doA">doA</a><br>
	<a href="${path}/test/doB">doB</a><br>
	<a href="${path}/test/doC">doC</a><br>
	<a href="${path}/test/doD">doD</a><br>
	<!-- AJax를 통해 비동기적으로 호출한다 -->
	<a href="javascript:doF()">doF</a><br>
	<div id="result"></div>
</body>
</html>