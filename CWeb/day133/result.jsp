<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>CHECK OK</h1>

<h3>${rv } : radio</h3>

<table border="1">
<tbody>
	<c:forEach var="cbv" items="${cbv }">
	<tr>
	<td>${cbv }</td>
	</tr>
	</c:forEach>
</tbody>
</table>

<h3>${sv } : select</h3>
</body>
</html>