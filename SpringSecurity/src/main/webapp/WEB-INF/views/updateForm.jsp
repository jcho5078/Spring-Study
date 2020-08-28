<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.web.security.user.vo.UserVO"%>
<% UserVO User = (UserVO) request.getAttribute("User"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 수정</title>
</head>
<body>
<form action="updateAllUser">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>수정</th>
		</tr>
		<tr>
			<td>${User.getId()}</td>
			<td><input type="text" name="pw" value="${User.getPw()}"></td>
			<td><input type="text" name="name" value="${User.getName()}"></td>
			<td>
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>