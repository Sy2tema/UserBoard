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
	<form name="form1" class="main" method="post" action="${ path }/user/insert.do">
		<table width="450px" border="0" cellspacing="0" cellpadding="1">
			<thead>
				<tr>
					<td colspan="2" align="center" width="100%"><div class="title">회원 가입</div></td>
				</tr>
			</thead>
			<tr>
				<td align="center" width="30%"><button class="button">아이디</button></td>
				<td width="70%"><input id="userid" name="userid" type="text" value="${ dto.userid }" /></td>
			</tr>
			<tr>
				<td align="center" width="30%"><button class="button">비밀번호</button></td>
				<td width="70%"><input id="password" name="password" type="password" value="${ dto.password }" /></td>
			</tr>
			<tr>
				<td align="center" width="30%"><button class="button">비밀번호 확인</button></td>
				<td width="70%"><input type="password" name="checkpassword" /></td>
			</tr>
			<tr>
				<td align="center" width="30%"><button class="button">이름</button></td>
				<td width="70%"><input name="username" type="text" value="${ dto.username }" /></td>
			</tr>
			<tr>
				<td align="center" width="30%"><button class="button">이메일</button></td>
				<td width="70%"><input name="email" type="text" value="${ dto.email }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="100%">
					<button class="button" type="submit" style="margin-bottom: 10px;">양식 제출</button>
					<div style="color: darkred;">${ message }</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>