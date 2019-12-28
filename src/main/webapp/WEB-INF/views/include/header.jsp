<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl에 대한 core태그와 format태그 -->
<!-- 이외에도 여러 가지 jstl에 대한 유용한 태그들이 존재한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- context경로 -->
<!-- JSP환경에서는 String path = request.getContextPath();라 입력해야 하는 부분이다 -->
<c:set var="path" value="${ pageContext.request.contextPath }" />

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>