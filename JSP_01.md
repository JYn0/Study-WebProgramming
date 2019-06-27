# JSP

## day13

WebServer안에 Servlet

JSP를 Servlet으로 변환하여 data를 html로 화면에 뿌려준다



jsp에 자바 코드가 들어가면 안됨

JSP는 서버에서 동작, servlet임

```html
hello.html

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
<h1>Hello Page</h1>
<form action="hello" method="POST">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<input type="submit" value="LOGIN"><br>
</form>
</body>
</html>
```

```java
HelloServlet.java


package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// data가 들어오는건 request, 나가는건 response
		System.out.println("doGet Start...");
		String id = request.getParameter("id"); // form의 id
		String pwd = request.getParameter("pwd");
		System.out.println(id+" "+pwd);
		
		// HTML5 => 만들어주기 
		//response.sendRedirect("ok.jsp?id="+id); // 현재servlet에서 다른쪽으로 이동시키는 것
		// ok.jsp가 처리해라 -> ok.jsp가 servlet으로 바뀌어서 html이 결과로 나온다.
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5); list.add(3); list.add(8);
		request.setAttribute("list1", list);
		
		ArrayList<Item> list2 = new ArrayList<Item>();
		list2.add(new Item("k1", 1000));
		list2.add(new Item("k2", 2000));
		list2.add(new Item("k3", 3000));
		list2.add(new Item("k4", 4000));
		list2.add(new Item("k5", 5000));
		request.setAttribute("list2", list2);
		
		request.setAttribute("id", id);
		request.setAttribute("cnt", 7);
		RequestDispatcher rd =request.getRequestDispatcher("ok.jsp");
		rd.forward(request, response);
		
		// 이 부분을 jsp가 처리해준다
		//int i = 10;
		// 서버프로그램은 web에 있다(java X)
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<H1>LOGIN OK</H1>");
//		out.println("<H1>"+id+"님 환영합니다.</H1>");
//		out.close();
	}

}
```

```jsp
ok.jsp

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
<h1>LOGIN OK.</h1>
<!-- EL -->
<h3>${id  } ${cnt }님 환영 합니다.</h3>
<!-- JSTL IF -->
<c:if test="${cnt > 5}">
<h3>High</h3>
</c:if>
<!-- JSTL CHOOSE WHEN THEN -->
<!-- if/else -> choose when -->
<c:choose> 
	<c:when test="${cnt >= 9}">
		<h4>1등급</h4>
	</c:when>
	<c:when test="${cnt >= 9 && cnt < 9}">
		<h4>2등급</h4>
	</c:when>
	<c:when test="${cnt >= 7 && cnt < 8}">
		<h4>3등급</h4>
	</c:when>
	<c:otherwise>
		<h4>F등급</h4>
	</c:otherwise>
</c:choose>
<!-- FOR 2 -->
<table border="1">
<tbody>
	<c:forEach var="it" items="${list2}">
	<tr>
	<td>${it.name }</td><td>${it.price }</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<!-- FOR 1 -->
<!-- var:사용할 이름, items:java에서 쓴 이름 -->
<c:forEach var="num" items="${list1}">
<h5>${num}</h5>
</c:forEach>
</body>
</html>
```

```java
Item.java


package com.sds;

public class Item {
	String name;
	int price;	
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}	
}
```



```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- doGet, doPost 영역 -->
<%
	int i = 10;
	String id = request.getParameter("id");
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN OK.</h1>
<h3><%=id %>님 환영 합니다.</h3>
<h3></h3>
</body>
</html>
```


