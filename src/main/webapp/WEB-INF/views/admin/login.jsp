<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 로그인</title>
	<%@ include file="../include/header.jsp" %>
	<script>
		$(function () {
			$("#loginButton").click(function () {
				const userid = $("#userid").val();
				const password = $("#password").val();

				if (userid === "") {
					alert("아이디 또는 비밀번호가 입력되지 않았습니다.");
					$("#userid").focus();
					return;
				}

				if (password === "") {
					alert("비밀번호가 입력되지 않았습니다.");
					$("#password").focus();
					return;
				}

				document.form1.action = "${ path }/admin/loginCheck.do";
				document.form1.submit();
			});
		});
	</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>로그인하기</h2>
	<form name="form1" method="post">
		<table width="400px">
			<tr>
				<td>아이디</td>
				<td><input id="userid" name="userid" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input id="password" name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="loginButton" style="margin-bottom: 20px;">로그인</button>
					<c:if test="${ param.message == 'guest' }">
						<div style="color: darkred;">
							아직 로그인되지 않았습니다.
						</div>
					</c:if>
					<c:if test="${ message == 'error' }">
						<div style="color: darkred;">
							아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${ message == 'logout' }">
						<div style="color: darkred;">
							로그아웃이 완료되었습니다.
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>