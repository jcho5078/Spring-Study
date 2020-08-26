<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.security.user.vo.UserVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserForm</title>
</head>
<body>
	<h1>유저 정보</h1>
	
	<form>
		<table>
			<tr>
				<th></th>
				<th>정보</th>
				<th>수정</th>
			</tr>
			<tr>
				<td><input type="text" name="pw" value="password"></td>
				<td><input type="text" name="name" value=""></td>
			</tr>
		</table>
	</form>
	
</body>
</html>