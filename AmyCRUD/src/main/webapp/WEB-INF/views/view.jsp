<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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

	<table border="1">
			<tr>
				<td>idx</td>
				<td>${view.idx}</td>
			</tr>
			<tr>
				<td>name</td>
				<td>${view.name}</td>
			</tr>
			<tr>
				<td>date</td>
				<td>${view.regdate}</td>
			</tr>
			<tr>
				<td>title</td>
				<td>${view.title}</td>
			</tr>	
			<tr>
				<td>contents</td>
				<td>${view.contents}</td>
			</tr>
		</table>
		<a href="Update.do?idx=${view.idx}">update</a> 		<a href="DeleteProc.do?idx=${view.idx}">delete</a> 
		<a href="main.do">home</a>

</body>
</html>