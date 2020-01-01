<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 회원 등록 페이지</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>회원 등록 양식</h2>
	<form name="form1" method="post" action="${ path }/user/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input name="userid" value="${ dto.userid }" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" value="${ dto.password }" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="checkpassword" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="username" value="${ dto.username }" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="email" value="${ dto.email }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록" />
					<div>${ message }</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>