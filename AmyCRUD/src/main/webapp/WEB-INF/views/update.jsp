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

<form action="UpdateProc.do">
	<table border="1">
			<tr>
				<td>idx</td>
				<td>${view.idx}</td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${view.name}"></td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text" name="title" value="${view.title}"></td>
			</tr>	
			<tr>
				<td>contents</td>
				<td><textarea name="contents">${view.contents}</textarea></td>
			</tr>
		</table>
		<input type="hidden" name="idx" value="${view.idx}">
		<input type="submit" value="update">
</form>

</body>
</html>