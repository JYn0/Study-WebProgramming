# JSP

## day0133



1. register.html

   radio button / select / checkbox

2. RegisterServlet(register).java

   데이터를 받아서 출력(System.out.println)

   데이터를 result.jsp에 출력 하시오

3. result.jsp

   radio값, select값

   checkbox값은 테이블에 출력

```html
register.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>

</script>
</head>
<body>

<form action="register" method="GET">

A <input type="radio" name="r" value="A">
Z <input type="radio" name="r" value="Z">
<hr>
Apple<input type="checkbox" name="cb" value="Apple">
Grape<input type="checkbox" name="cb" value="Grape">
Orange<input type="checkbox" name="cb" value="Orange">
Mellon<input type="checkbox" name="cb" value="Mellon">
<hr>
<select name="team">
	<option value="Wiz">Wiz</option>
	<option value="Kia">Kia</option>
	<option value="Dinos">Dinos</option>
</select>

<input type="submit" value="CHECK">

</form>

</body>
</html>
```

```java
RegisterServlet.java


package com.sds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rv = request.getParameter("r"); // radio
		String sv = request.getParameter("team"); // select
		String cbv[] = request.getParameterValues("cb"); //checkbox
		System.out.println(Arrays.toString(cbv));
		
		System.out.println("rv: "+rv+"   sv: "+sv);
		
		request.setAttribute("rv", rv);
		request.setAttribute("cbv", cbv);
		request.setAttribute("sv", sv);
		
		RequestDispatcher vv = request.getRequestDispatcher("result.jsp");
		vv.forward(request, response);
		
	}

}
```

```jsp
result.jsp


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
```





