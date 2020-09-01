<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h2>글 작성</h2>
	<form action="insert">
		<table border="1" style="width: 700px; height: 1500px">
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; font-weight: bold; text-align: center;">
					작성자
				</td>
				<td style="width: 75vw;">
					<%= request.getAttribute("name") %>
				</td>
			</tr>
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; font-weight: bold;  text-align: center;">
					제목
				</td>
				<td>
					<input type="text" id="title">
				</td>
			</tr>
			<tr>
				<td style="background-color: #DCDCDC; width: 25vw; font-weight: bold;  text-align: center;">
					내용
				</td>
				<td>
					<input type="text" id="content">
				</td>
			</tr>
		</table>
		<input type="submit" value="작성완료">
	</form>
</body>
</html>