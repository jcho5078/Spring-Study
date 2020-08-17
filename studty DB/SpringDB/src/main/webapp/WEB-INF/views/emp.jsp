<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jcho5078.usedb.vo.EmpVO"%>
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
	<table>
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
</body>
</html>