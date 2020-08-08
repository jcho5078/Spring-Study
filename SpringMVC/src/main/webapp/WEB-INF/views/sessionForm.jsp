<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sessionForm2" method="get">
		<fieldset>
			<legend>뷰 Form</legend>
			이름: <input type="text" name="name"><br>
			비밀번호: <input type="text" name="pw"><br>
			<input type="submit" value="전송"><br>
			<br>
			전송한 세션: ${session}
		</fieldset>
	</form>
</body>
</html>