# Ajax

## day10

Asynchronous JavaScript and XML

: 서버와 데이터를 교환하는 기술의 하나



오류

properties - java build path - libraries-add Library...-Server Runtime - add



서버 : JavaResources - src - create Servlet

add : /login



* Ajax 1(p.490, 기존방식)

  ```html
  aj1.html
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <style></style>
  <script>
  $(document).ready(function(){
  	$('input[type="button"]').click(function(){
  		$('#login_form').attr('method','get');
  		$('#login_form').attr('action','login');
  		$('#login_form').submit();
  	});
  });
  </script>
  </head>
  <body>
  <h1>LOGIN</h1>
  <form id="login_form">
  ID<input type="text" name="id"><br>
  PWD<input type="password" name="pwd"><br>
  <input type="button" value="LOGIN">
  </form>
  </body>
  </html>
  ```

  ```java
  LoginServlet.java
  
  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class LoingServlet
   */
  @WebServlet({ "/LoingServlet", "/login" })
  public class LoingServlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	/**
  	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		System.out.println("LoginServlet Called..!");
  		String id = request.getParameter("id");
  		String pwd = request.getParameter("pwd");
  		
  		if(id.equals("aaa") && pwd.equals("111")) {
  			response.sendRedirect("loginok.html");
  		}else {
  			response.sendRedirect("loginfail.html");
  		}
  
  	}
  
  }
  ```
  
  ```html
  loinok.html

  
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
  <h1>LOGIN OK PAGE</h1>
  </body>
  </html>
  
  
  loginfail.html
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
  <h1>LOGIN FAIL PAGE</h1>
  </body>
  </html>
  ```
  
  
  
* aj2.html (p.498 Ajax)

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <style></style>
  <script>
  $(document).ready(function(){
  	$('button').click(function(){
  		$('#cf').attr('method','GET'); // GET방식으로 서버 호출
  		$('#cf').attr('action','calc1'); // calc1에 전송
  		$('#cf').submit();
  	});
  });
  </script>
  </head>
  <body>
  <form id="cf">
  NUM1<input type="number" name="num1"><br>
  NUM2<input type="number" name="num2"><br>
  <button>Calc</button>
  </form>
  </body>
  </html>
  ```

  ```java
  Calc1Servlet.java
  
  package com.sds;
  
  import java.io.IOException;
  import java.io.Writer;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class Calc1Servlet
   */
  @WebServlet({ "/Calc1Servlet", "/calc1" })
  public class Calc1Servlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String num1 = request.getParameter("num1");
  		String num2 = request.getParameter("num2");
  		int n1 = Integer.parseInt(num1);
  		int n2 = Integer.parseInt(num2);
  		int result = n1+n2;
  		Writer out = response.getWriter();
  		out.write("<h1>"+result+"</h1>"); // 새로운 화면 
  		out.close();
  	}
  
  }
  ```

  



* aj3.html

  * aj2.jtml을 Ajax로 작성
  *  버튼을 클릭하면 값을 가져오고 ajax를 이용하여 서버로 전송하고, 결과를 받아 다시 화면으로 전송

  ```html
  aj3.html
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <style></style>
  <script>
  function display(data){
  	$('h1').text(data);
  };
  function sendData(n1, n2){
  	var surl = 'calc1';
  	$.ajax({ // Ajax로 전송, {}객체로
  		url:surl,
  		method:"post", // 방식
  		data:{"num1":n1, "num2":n2},
  		success:function(result){ // 서버에서 결과를 보내주면 받는 곳, result로 받음
  			//alert('['+result+']'); // 혹시 앞뒤에 공백이 붙을까봐
  			display(result);
  		}
  	}); 
  };
  $(document).ready(function(){
  	$('button').click(function(){
  		var num1 = $('input[name="num1"]').val();
  		var num2 = $('input[name="num2"]').val();
  		sendData(num1,num2); // 서버로 전송
  	});
  });
  </script>
  </head>
  <body>
  <h1></h1> <!-- 결과 출력하는 곳 -->
  NUM1<input type="number" name="num1"><br>
  NUM2<input type="number" name="num2"><br>
  <button>Calc</button>
  </body>
  </html>
  ```

  ```java
  Calc1Servlet.java
  
  
  package com.sds;
  
  import java.io.IOException;
  import java.io.Writer;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class Calc1Servlet
   */
  @WebServlet({ "/Calc1Servlet", "/calc1" })
  public class Calc1Servlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String num1 = request.getParameter("num1");
  		String num2 = request.getParameter("num2");
  		int n1 = Integer.parseInt(num1);
  		int n2 = Integer.parseInt(num2);
  		int result = n1+n2;
  		Writer out = response.getWriter(); // 객체
  		out.write("<h1>"+result+"</h1>"); // 새로운 화면, html을 가상으로 만들어서 보냄
  		out.close();
  	}
  
  	@Override
  	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		String num1 = req.getParameter("num1");
  		String num2 = req.getParameter("num2");
  		int n1 = Integer.parseInt(num1);
  		int n2 = Integer.parseInt(num2);
  		int result = n1+n2;
  		Writer out = resp.getWriter();
  		out.write(result+""); // result 보내기, 값만 보냄, +"" => string으로 변환
  		out.close();
  	}	
  }
  ```

  

* aj4.html(회원가입)

  * key up -> server -> id중복 확인 

  ```html
  aj4.html
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <style></style>
  <script>
  function display(result){
  	if(result=='1'){
  		$('span').text('사용가능합니다.');
  	}else{
  		$('span').text('이미사용중입니다.');
  	}
  }
  function checkId(id){
  	$.ajax({
  		url:'register',
  		data:{'id':id,},
  		method:'get',
  		success:function(result){
  			// alert(result);
  			display(result);
  		}
  	});
  };
  $(document).ready(function(){
  	$('input[type="button"]').click(function(){
  		$('#login_form').attr('method','post');
  		$('#login_form').attr('action','register');
  		$('#login_form').submit();
  	});
  
  	$('input[name="id"]').keyup(function(){
  		var id = $(this).val();
  		checkId(id);
  	});
  
  });
  </script>
  </head>
  <body>
  <h1>REGISTER</h1>
  <form id="login_form">
  ID<input type="text" name="id"><span></span><br>
  PWD<input type="password" name="pwd"><br>
  NAME<input type="text" name="name"><br>
  <input type="button" value="LOGIN">
  </form>
  </body>
  </html>
  ```

  ```java
  RegisterServlet.java
  
  
  package com.sds;
  
  import java.io.IOException;
  import java.io.PrintWriter;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class RegisterServlet
   */
  @WebServlet({ "/RegisterServlet", "/register" })
  public class RegisterServlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	// ID Check
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String id = request.getParameter("id");
  		String result = "1";
  		if(id.equals("aaaa")) {
  			result = "0";
  		}
  		PrintWriter out = response.getWriter();
  		out.print(result);
  		out.close();
  	}
  	
  	// 회원가입
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// 값 받아오기
  		String id = request.getParameter("id");
  		String pwd = request.getParameter("pwd");
  		String name = request.getParameter("name");
  		System.out.println(id+" "+pwd+" "+name);
  		response.sendRedirect("registerok.html");
  	}
  
  }
  ```

  ```html
  registerok.html
  
  
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
  <h1>REGISTER OK PAGE</h1>
  </body>
  </html>
  ```

  

* aj5.html(실시간검색어)

  * JSON Library Download 복사 => WEB-INF/lib 붙여넣기

  ```html
  aj5.html
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <style>
  div{
  	width:300px;
  	border:2px solid red;
  }
  </style>
  <script>
  /*
  [
  	{"rank":1,"keyword":"A","type":"up","cnt":10},
  	{"rank":1,"keyword":"B","type":"down","cnt":1},
  	{"rank":1,"keyword":"C","type":"down","cnt":1},
  	{"rank":1,"keyword":"D","type":"up","cnt":7},
  	{"rank":1,"keyword":"E","type":"up","cnt":50}
  ]
  */
  function display(data){ // 내려온 data를 화면에 뿌려줌
  	$('div').empty();
  	$(data).each(function(index,item){ // for문(each)
  		var str = '';
  		str += '<h3>';
  		str += item.rank+" "+item.keyword+" "+item.type+" "+item.cnt;
  		str += '</h3>';
  		$('div').append(str);
  	});
  };
  function getData(){
  	$.ajax({ // 요청만 하는것
  		url:'chart',
  		success:function(result){ // Jason으로 data가 내려옴 
  			//alert(result);
  			display(eval(result)); //String ->JavaScript Object
  		}
  	});
  };
  $(document).ready(function(){
  	getData();
  	setInterval(getData,3000); // 3초에 한번씩 호출하기
  });
  </script>
  </head>
  <body>
  <h1>Keyword Chart</h1>
  <div></div>
  </body>
  </html>
  ```

  ```java
  ChartServlet.java
  
  
  package com.sds;
  
  import java.io.IOException;
  import java.io.PrintWriter;
  import java.util.Random;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  import org.json.simple.JSONArray;
  import org.json.simple.JSONObject;
  
  
  
  @WebServlet({ "/ChartServlet", "/chart" })
  public class ChartServlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setCharacterEncoding("UTF-8");
  		PrintWriter out = response.getWriter();
  		
  		Random r = new Random();
  		
  		// make json data
  		JSONArray ja = new JSONArray();
  		for(int i=0; i<10; i++) {
  			int temp = r.nextInt(10)+1;
  			JSONObject jo = new JSONObject();
  				jo.put("rank", i+1);
  				jo.put("keyword","아"+temp);
  				if(temp%2 == 0) {
  					jo.put("type", "↑");
  				}else {
  					jo.put("type", "↓");
  				}
  				jo.put("cnt", temp);
  				ja.add(jo);
  		}
  		// and response client
  		out.print(ja.toJSONString());
  		out.close();
  	}
  
  }
  ```

  

  