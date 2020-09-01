<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="로그아웃" />
</form>
<h2>페이지 이동</h2>
<h3>*<a href="user/userForm" >유저 정보 확인</a></h3>
<h3>*<a href="board">게시판</a></h3>
<hr>
<h3>*<a href="manage/viewAllUser" >유저 목록 확인(관리자)</a></h3>

</body>
</html>
