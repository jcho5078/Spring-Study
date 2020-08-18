<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jcho5078.usedb.vo.EmpVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	List<EmpVO> commonList = (List<EmpVO>) request.getAttribute("empList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>HIREDATE</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
		</tr>
		<%
			if(commonList.size()>0){
				for(int i=0 ; i<commonList.size() ; i++){
		%>
		<tr>
			<td><%=commonList.get(i).getEmpno() %></td>
			<td><%=commonList.get(i).getEname() %></td>
			<td><%=commonList.get(i).getJob() %></td>
			<td><%=commonList.get(i).getMgr() %></td>
			<td><%=commonList.get(i).getHiredate() %></td>
			<td><%=commonList.get(i).getSal() %></td>
			<td><%=commonList.get(i).getComm() %></td>
			<td><%=commonList.get(i).getDeptno() %></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	
	<hr><!-- jstl로 list 출력 -->
	
	<table border="1">
	<thead>
	<tr>
		<th>EMPNO</th>
		<th>ENAME</th>
		<th>JOB</th>
		<th>MGR</th>
		<th>HIREDATE</th>
		<th>SAL</th>
		<th>COMM</th>
		<th>DEPTNO</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${empList}">
		<tr>
			<td>${item.empno}</td>
			<td>${item.ename}</td>
			<td>${item.job}</td>
			<td>${item.mgr}</td>
			<td>${item.hiredate}</td>
			<td>${item.sal}</td>
			<td>${item.comm}</td>
			<td>${item.deptno}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>