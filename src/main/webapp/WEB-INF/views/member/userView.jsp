<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 페이지</title>
	<%@ include file="../include/header.jsp" %>
	<script type="text/javascript">
		$(document).ready(() => {
			// 회원 정보 수정 버튼 클릭시 이벤트
			$(#updateButton).click(() => {
				document.form1.action = "${ path }/member/update.do";
				document.form1.submit();
			});
			
			// 회원 삭제 버튼 클릭시 이벤트
			$(#deleteButton).click(() => {
				if (confirm("정말 삭제하시겠습니까?")) {
					document.form1.action = "${ path }/member/delete.do";
					document.form1.submit();
				}
			});
		});
	</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>회원 정보</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input name="userid" value="${ dto.userid } readonly" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" /></td>
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
				<td>회원 등록 일자</td>
				<td>
					<fmt:formatDate value="${ dto.signup_date }"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>