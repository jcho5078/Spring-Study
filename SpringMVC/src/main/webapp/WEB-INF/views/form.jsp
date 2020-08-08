<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form 페이지</h2>
	<br>
	<form action="event" method="get"><!-- 뷰에서 값을 컨트롤러 단으로 보내기 위해서는 해당 url로 보내기 -->
		<fieldset>
			<legend>Get</legend>
			이름: <input type="text" name="name"><br>
			비밀번호: <input type="text" name="pw"><br>
			<input type="submit" value="전송"><br>
			<br>
			전송한 값: ${name} , ${pw}
		</fieldset>
	</form>
	<form action="event1" method="post">
		<fieldset>
			<legend>Post</legend>
			이름: <input type="text" name="name"><br>
			비밀번호: <input type="text" name="pw"><br>
			세션: ${evnetForm.type}<br>
			<input type="submit" value="전송"><br>
			<br>
			전송한 값: ${name} , ${pw}
		</fieldset>
	</form>
</body>
</html>