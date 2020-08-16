<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="com.my.web.vo.EmpVO"%>
<%
	List<EmpVO> commonList = (List<EmpVO>) request.getAttribute("empList");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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