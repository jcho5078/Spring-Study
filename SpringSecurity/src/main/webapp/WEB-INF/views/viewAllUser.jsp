<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All User</title>
<script type="text/javascript">

function move() {
	f.action = "javascript_function"; //호출명
	f.method = "post"; //POST방식 
	f.submit();
}
</script>

</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>HIREDATE</th>
			<th>정보 수정</th>
			<th>탈퇴</th>
		</tr>
		<c:forEach var="user" items="${viewAllUser}">
		<tr>
			<td>${user.id}</td>
			<td>${user.pw}</td>
			<td>${user.name}</td>
			<td>${user.hiredate}</td>
			<td><input type="button" name="modify" value="수정"></td>
			<td><input type="button" name="delete" value="삭제"></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>