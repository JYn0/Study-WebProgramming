<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<h1>Product List Page</h1>
<c:forEach var="p" items="${plist }">
	<h4><a href="product.do?cmd=productdetail&id=${p.id }">${p.id }</a>  ${p.name }  ${p.price }</h4>
</c:forEach>
</body>
</html>
