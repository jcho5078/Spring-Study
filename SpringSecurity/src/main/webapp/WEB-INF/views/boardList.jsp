<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<a href="board/boardinsert">글 작성</a>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>글 제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="list" items="${boardList}">
		<tr>
			<td>
				<c:out value="${list.bdnum}"/>
			</td>
			<td>
				<c:out value="${list.name}"/>
			</td>
			<td>
				<a href="board/readBoard?bdnum=${list.bdnum}"><c:out value="${list.title}"/></a>
			</td>
			<td>
				<c:out value="${list.writedate}"/>
			</td>
		</tr>
		</c:forEach>		
	</table>
</body>
</html>