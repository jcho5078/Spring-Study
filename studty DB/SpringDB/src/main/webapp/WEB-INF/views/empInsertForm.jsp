<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jcho5078.usedb.vo.EmpVO"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form name="insertEmp" action="empInsert">
		<table border="1">
			<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>JOB</th>
				<th>SAL</th>
			</tr>
			<tr>
				<td><input type="text" name="empno" value="empno"></td>
				<td><input type="text" name="ename" value="ename"></td>
				<td><input type="text" name="job" value="job"></td>
				<td><input type="text" name="sal" value="sal"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등록"/></td>
			</tr>
		</table>
	</form:form>
	<hr>
	<form:form name="deleteEmp" action="empDelete">
		<table border="1" style="size: 300px">
			<tr>
				<th>삭제 하려는 ROW의 EMPNO 입력</th>
			</tr>
			<tr>
				<td><input type="text" name="empno" value="empno"></td>
			</tr>
			<tr>
				<td><input type="submit" value="삭제"/></td>
			</tr>
		</table>
	</form:form>
	<hr>
	<form:form name="updateEmp" action="empUpdate">
		<table border="1" style="size: 300px">
			<tr>
				<th>수정하려는 ROW의 EMPNO와 변경하려는 값 입력</th>
			</tr>
			<tr>
				<td><input type="text" name="empno" value="empno"></td>
				<td><input type="text" name="ename" value="ename"></td>
				<td><input type="text" name="job" value="job"></td>
				<td><input type="text" name="sal" value="sal"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>