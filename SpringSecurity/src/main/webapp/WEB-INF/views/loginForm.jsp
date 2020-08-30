<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginPass" method="post">
		ID: <input type="text" name="id">
		PW: <input type="password" name="pw">
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>