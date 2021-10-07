<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/resources/css/table.css" rel="stylesheet" type="text/css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

Welcome, Amy Board! <br>
Total: ${total} <br>
	<a href="Insert.do">write</a> <br>
<table border="1">
	<thead>
		<tr>
			<td style="width:50px;">idx</td>
			<td>title</td>
			<td style="width:100px;">name</td>
			<td style="width:85px;">date</td>
		</tr>
	</thead>
	<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.idx}</td>
		<td><a href="ViewPost.do?idx=${dto.idx}">${dto.title}</a></td>
		<td>${dto.name}</td>
		<td>${dto.regdate.substring(0, 10)}</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>