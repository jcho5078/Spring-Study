<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="signUp" name="insertUser" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		NAME: <input type="text" name ="name"><br>
		<input type="submit" value="회원가입">
	</form>
	<hr>
	<form:form action="signUp" name="insertUser" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		NAME: <input type="text" name ="name"><br>
		<input type="submit" value="회원가입">
	</form:form>
</body>
</html>