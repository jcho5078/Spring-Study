<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>글 작성</h2>
	<form action="boardinsert/insert" method="post">
		<table border="1" style="width: 700px; height: 700px;">
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; height:5vh; font-weight: bold; text-align: center;">
					작성자
				</td>
				<td style="width: 75vw;">
					<%= request.getAttribute("name") %>
					<input type="hidden" id="name" name="name" value="<%= request.getAttribute("name")%>">
				</td>
			</tr>
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; height:5vh; font-weight: bold;  text-align: center;">
					제목
				</td>
				<td>
					<input type="text" id="title" name="title" style="width: 25vw;">
				</td>
			</tr>
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; height:90vh; font-weight: bold;  text-align: center;">
					내용
				</td>
				<td>
					<textarea id="content" name="content" style="width: 25vw; height:80vh;"></textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="작성완료">
	</form>
</body>
</html>