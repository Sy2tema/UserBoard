<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 페이지</title>
	<%@ include file="../include/header.jsp" %>
	<style>
		td {
			padding-left: 10px;
			padding-top: 6px;
			padding-bottom: 6px;
		}
		table, h2 {
			margin-left: 10px;
		}
		.prop {
			font-weight: bold;
		}
	</style>
	<script type="text/javascript">
		$(function () {
			// 회원 정보 수정 버튼 클릭시 이벤트
			$("#updateButton").click(function () {
				document.form1.action = "${ path }/user/update.do";
				document.form1.submit();
			});
			
			// 회원 삭제 버튼 클릭시 이벤트
			$("#deleteButton").click(function () {
				if (confirm("정말 삭제하시겠습니까?")) {
					document.form1.action = "${ path }/user/delete.do";
					document.form1.submit();
				}
			});
		});
	</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>${ dto.username } 님의 회원 정보</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td class="prop">아이디</td>
				<td>${ dto.userid }</td>
			</tr>
			<tr>
				<td class="prop">비밀번호</td>
				<!-- 수정을 원하지 않을 때는 readonly속성을 사용할 수도 있다 -->
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td class="prop">이름</td>
				<td><input name="username" value="${ dto.username }" /></td>
			</tr>
			<tr>
				<td class="prop">이메일</td>
				<td><input name="email" value="${ dto.email }" /></td>
			</tr>
			<tr>
				<td class="prop">회원 등록 일자</td>
				<td>
					<fmt:formatDate value="${ dto.signup_date }"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="정보 수정" id="updateButton" />
					<input type="button" value="회원 정보 삭제" id="deleteButton" />
					<div style="color: red;">${ message }</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>