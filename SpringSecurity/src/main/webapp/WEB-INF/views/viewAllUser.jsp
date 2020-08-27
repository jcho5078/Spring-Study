<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All User</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
			<td>
				<input type="button" id="modify" value="수정">
			</td>
			<td>
				<input type="button" id="delete" value="삭제">
			</td>
		</tr>
		</c:forEach>
	</table>
<script type="text/javascript">

$("#modify").click(function() {
	
	var tdArr = new Array();
	var object = new Object();//json 배열에 넣을 object
	var Btn = $(this);
	
	var tr = Btn.parent().parent();
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
	
	$.ajax({
		
		dataType:'json',
		contentType: "application/json; charset=UTF-8", //JSON데이터를 보낼 때, 꼭 application/json으로 설정.
		type: "POST",
		data: JSON.stringify(object), //JSON데이터를 보낼 때, 꼭 stringify()함수를 써서 데이터를 보내야 @ResponseBody에서 정보 받을 수 있음.
		url: "${pageContext.request.contextPath}/manage/updateAllUserForm",
		success: function(data) {
			console.log(JSON.stringify(tdArr));
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log('error while post');
		}
	});
});

$("#delete").click(function() {
	var tdArr = new Array();
	var Btn = $(this);
	
	var tr = Btn.parent().parent;
	var td = tr.children();
	
	var id = td.eq(0).text();
	var pw = td.eq(1).text();
	var name = td.eq(2).text();
	var hiredate = td.eq(3).text();
	
	td.each(function(i) {
		tdArr.push(td.eq(i).text());
	});
	
});
</script>
</body>
</html>