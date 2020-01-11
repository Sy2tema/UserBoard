<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align: center">
	| <a href="${ path }/admin/admin_main.do">홈 화면</a> |
	<a href="${ path }/user/list.do">회원 관리</a> |
	<a href="${ path }/upload/upload_form">파일 업로드</a> |
	<a href="${ path }/board/list.do">게시글 보기</a> |
</div>
<div style="text-align: right;">
	<c:choose>
		<c:when test="${ sessionScope.userid == null }">
			| <a href="${ path }/user/signup.do">회원가입</a> | 
			<a href="${ path }/user/login.do">로그인하기</a> |
		</c:when>
		<c:otherwise>
			${ sessionScope.username }님, 환영합니다. | 
			<a href="${ path }/user/logout.do">로그아웃하기</a>
		</c:otherwise>
	</c:choose>
</div>

<hr>