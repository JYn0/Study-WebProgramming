

# HTML

## day02



#### Web Programming - HTML

JavaScript Resources -> Java가 제공하는 것

Server에서 동작하는 프로그램은 자바로 제작

Java의 서버 프로그램이 동작될곳 => JavaScript Resources

web폴더는 서버에서 동작X



- Hyper Link

  href => 주소, 페이지 이동

  <a> -> 커서가 손가락 모양으로 바뀜

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  </head>
  <body>
  <h1>Hyper Link</h1> <!--block-->
  <a href="">Click1</a> <!--inline-->
  <a href="">Click2</a>
  </body>
  </html>
  
  <h1>Hyper Link</h1>
  <a href="http://www.naver.com">Click1</a>
  <a href="http://www.daum.net">Click2</a>
  
  <h3><a href="http://www.naver.com">Click1</a></h3>
  <!--block로 속성이 바뀌고 글씨가 커짐, 하지만 a는 inline속성-->
  
  /web/a.html
  <h3><a href="b1.html">Click1</a></h3> <!--같은폴더-->
  <a href="b/b2.html">Click2</a><!--다른 b폴더-->
  /web/b1.html
  <h1>Page B1</h1>
  /web/b/b2.html
  <h1>Page B2</h1>
  <a href="../a.html">HOME</a>
  
  <h3><a href="b1.html" target="_blank">Click1</a></h3>
  <!--새로운 창에서 실행, 보안상이유로 잘 안씀-->
  
  <!--element에 id부여-->
  <!--동일한 id를 써도 에러는 안나지만 다음으로 넘어가지않음-->
  <h1>Hyper Link</h1>
  <h3><a href="b1.html" target="_blank">Click1</a></h3>
  <a href="b/b2.html">Click2</a>
  <a href="#h_target2">Click3</a>
  <h1>Header1</h1>
  <h1>Header1</h1>
  <h1 id="h_target1">Header3</h1>
  <h1>Header1</h1>
  <h1>Header1</h1>
  <h1>Header1</h1>
  <h1 id="h_target2">Header7</h1>
  <h1>Header1</h1>
  <h1>Header1</h1>
  <h1>Header1</h1>
  
  <a href="file/tomcat.zip">Click4</a> <!--download-->
  <a href="#" onclick="send();">Click5</a> <!-- 아무 link작업을 안하겠다 : #으로 막기 / send()실행 -->
  
  ```




#### Web Programming - CSS+ JavaScript

- CSS + JavaScript

  ```html
  <!-- haed안에, title 위에 -->
  <style> CSS </style>
  <script>JavaScript</script>
  
  <head>
  <meta charset="EUC-KR">
  <style>
  a{
  	text-decoration: none;
  	color:red;
  	font-size: 2em;
  }
  </style><!-- CSS -->
  <script>
  function send(){
  	alert('Are you ok ?');
  	location.href = 'b1.html';
  };
  </script><!-- Java Script -->
  <title>Insert title here</title>
  </head>
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <style>
  img{
  	width:100px;
  	height:125px;
  	display: block;<!-- block속성으로 바꾸기 -->
  }
  </style>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>IMG TEST</h1>
  <a href="img/m1.jpg" target="_balnk"><img src="img/m1.jpg"></a>
  <img src="img/m2.jpg">
  <img src="img/m3.jpg">
  <img src="img/m4.jpg">
  <img src="img/m5.jpg">
  </body>
  </html>
  ```

  

- table

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <style>
  	table, td, tr, th{
  		border:2px solid black;
  	}
  	table{
  		width:300px;
  		border-collapse: collapse;
  	}
  </style>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>Table Test</h1>
  <table>
  	<caption>Emplyee List</caption>
  	
  	<thead>
  		<tr>
  			<th>ID</th><th>PWD</th><th>NAME</th>
  		</tr>
  	</thead>
  	
  	<tbody>
  	<tr>
  		<td>id01</td><td>pwd01</td><td>무지</td>
  	</tr>
  	<tr>
  		<td>id02</td><td>pwd02</td><td>콘</td>
  	</tr>
  	<tr>
  		<td>id03</td><td>pwd03</td><td>라이언</td>
  	</tr>
  	<tr>
  		<td>id04</td><td>pwd04</td><td>어피치</td>
  	</tr>
  	<tr>
  		<td>id05</td><td>pwd05</td><td>네오</td>
  	</tr>
  	</tbody>
  </table>
  </body>
  </html>
  ```

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  </head>
  <body>
  <table border="1">
  	<caption>Number List</caption>
  	<thread>
  		<tr><th>one</th><th>two</th><th>three</th></tr>
  	</thread>
  	<tbody>
  		<tr><td colspan="2">1</td><td rowspan="3">3</td></tr>
  		<tr><td>4</td><td>5</td></tr>
  		<tr><td>7</td><td>8</td>></tr>
  	</tbody>
  </table>
  </body>
  </html>
  ```
  
  
  
  