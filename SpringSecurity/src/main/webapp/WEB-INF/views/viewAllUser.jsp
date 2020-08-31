<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All User</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<sec:authorize access="hasAuthority('ROLE_MANAGER')">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>HIREDATE</th>
			<th>AUTHORITY</th>
			<th>정보 수정</th>
			<th>탈퇴</th>
		</tr>
		<c:forEach var="user" items="${viewAllUser}">
		<tr>
			<td>${user.id}</td>
			<td>${user.pw}</td>
			<td>${user.name}</td>
			<td>${user.hiredate}</td>
			<td>${user.authority}</td>
			<td>
				<form action="updateAllUserForm" id="modifyForm" method="post">
					<input type="button" id="modify"value="수정">
					<input type="hidden" id="id" name="id" value="">
					<input type="hidden" id="pw" name="pw" value="">
					<input type="hidden" id="name" name="name" value="">
					<input type="hidden" id="hiredate" name="hiredate" value="">
				</form>
			</td>
			<td>
				<form action="deleteAllUser" id="deleteForm" method="post">
					<input type="button" id="delete" value="삭제">
					<input type="hidden" id="delete_id" name="id" value="">
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	</sec:authorize>
	<sec:authorize access="hasAuthority('ROLE_USER')">
		<h1>권한이 없습니다.</h1>
	</sec:authorize>
<script type="text/javascript">

$("#modify").click(function() {
	var tdArr = new Array();
	var object = new Object();//json 배열에 넣을 object (여기선 사용 안하지만, 여러 개의 JSON객체를 사용하는 배열 용.)
	var Btn = $(this);
	
	var tr = Btn.parent().parent().parent();
	var td = tr.children();
	
	var id = td.eq(0).text();
	var pw = td.eq(1).text();
	var name = td.eq(2).text();
	var hiredate = td.eq(3).text();
	
	object.id = id;
	object.pw = pw;
	object.name = name;
	object.hiredate = hiredate;
	
	tdArr.push(object);
	
	console.log(JSON.stringify(tdArr));
	console.log(JSON.stringify(object));
	
	document.getElementById("id").value = id;
	document.getElementById("pw").value = pw;
	document.getElementById("name").value = name;
	document.getElementById("hiredate").value = hiredate;
	
	console.log(document.getElementById("id").value);
	
	document.getElementById("modifyForm").submit();
});

$("#delete").click(function() {
	
	var Btn = $(this);
	
	var tr = Btn.parent().parent().parent();
	var td = tr.children();
	
	var id = td.eq(0).text();
	
	document.getElementById("delete_id").value = id;
	
	document.getElementById("deleteForm").submit();
});
</script>
</body>
</html>