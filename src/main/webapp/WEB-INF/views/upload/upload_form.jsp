<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 업로드 페이지</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<form name="form1" method="post"
		action="${ path }/upload/uploadForm" 
		enctype="multipart/form-data" target="iframe1">
		<!-- Controller의 변수명과 file을 담는 태그의 name속성의 값이 같아야 한다 -->
		<input type="file" name="file" />
		<input type="submit" value="업로드하기" />
	</form>
	<iframe name="iframe1"></iframe>
</body>
</html>