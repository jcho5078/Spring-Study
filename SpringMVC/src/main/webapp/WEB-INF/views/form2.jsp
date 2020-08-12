<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form2 페이지</h2>
	<br>
	<form:form action="event2"><!-- 뷰에서 값을 컨트롤러 단으로 보내기 위해서는 해당 url로 보내기 --> 
		<!-- commandName 속성만으로 커맨드객체의 값을 가져올 수가 없다. -->
		<fieldset>
			<legend>"vv" 커스텀 객체 값 가져오기</legend>
			이름: <input type="text" name="name"><br>
			비밀번호: <input type="text" name="pw"><br>
			<input type="submit" value="전송"><br>
			<br>
			전송한 값: ${vo.name} , ${vo.pw}
		</fieldset>
	</form:form>
	<form:form action="event3" method="post">
		<fieldset>
			<legend>"vo" 커스텀 객체 값 가져오기</legend>
			이름: <input type="text" name="name"><br>
			비밀번호: <input type="text" name="pw"><br>
			세션: ${evnetForm.type}<br>
			<input type="submit" value="전송"><br>
			<br>
			전송한 값: ${vv.name} , ${vv.pw}
		</fieldset>
	</form:form>
</body>
</html>