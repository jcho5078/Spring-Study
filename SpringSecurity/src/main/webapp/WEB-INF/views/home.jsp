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

<h2>페이지 이동</h2>
<h3>*<a href="" >로그아웃</a></h3>
<h3>*<a href="userForm" >유저 정보 확인</a></h3>
<hr>
<h3>*<a href="manage/viewAllUser" >유저 목록 확인(관리자)</a></h3>

</body>
</html>
