<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.web.security.board.vo.BoardVO" %>
<%@ page import="java.util.List"%>
<% BoardVO vo = (BoardVO)request.getAttribute("viewBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<h2>글 보기</h2>
<body>
	<table border="1">
		<tr>
			<th><c:out value="${viewBoard.title}"/></th>
		</tr>
		<tr>
			<td>
				작성자: <c:out value="${viewBoard.name}"/><br>
				작성 날짜: <c:out value="${viewBoard.writedate}"/>
			</td>
		</tr>
		<tr>
			<td><c:out value="${viewBoard.content}"/></td>
		</tr>
	</table>
</body>
</html>