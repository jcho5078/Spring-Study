<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The location on the server is ${locale}. </P>
<P>  The time on the server is ${serverTime}. </P>
${session}

<a href="test">test 이동</a><br>
<a href="board/0">board 0 page 이동</a><br>
<a href="board/1">board 1 page 이동</a><br>
<a href="eventForm">뷰 => 컨트롤러에 값 전송 후 받아오기</a><br>
</body>
</html>
