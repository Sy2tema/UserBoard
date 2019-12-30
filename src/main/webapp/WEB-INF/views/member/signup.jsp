<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 회원 등록 페이지</title>
	<%@ include file="../include/header.jsp" %>
	<style>
		td {
			padding-left: 10px;
		}
		h2, table {
			margin-left: 10px;
		}
		input {
			margin: 3px 3px;
		}
	</style>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>회원 등록 양식</h2>
	<form name="form1" method="post" action="${ path }/member/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input name="userid" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록" /></td>
			</tr>
		</table>
	</form>
</body>
</html>