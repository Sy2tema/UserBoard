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
	<form name="form1" class="main" method="post">
		<table width="450px" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="2" align="center" width="100%"><div class="title">UserBoardProj</div></td>
				</tr>
			</thead>
			<tr>
				<td align="center" width="30%"><button class="button">아이디</button></td>
				<td width="70%"><input id="userid" name="userid" type="text" /></td>
			</tr>
			<tr>
				<td align="center" width="30%"><button class="button">비밀번호</button></td>
				<td width="70%"><input id="password" name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="100%">
					<button class="button" id="loginButton" style="margin-bottom: 10px;">로그인</button>
					<c:if test="${ param.message == 'guest' }">
						<div style="color: darkred; margin-right: 105px;">
							아직 로그인되지 않았습니다.
						</div>
					</c:if>
					<c:if test="${ message == 'error' }">
						<div style="color: darkred; margin-right: 105px;">
							아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${ message == 'logout' }">
						<div style="color: darkred; margin-right: 105px;">
							로그아웃이 완료되었습니다.
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>