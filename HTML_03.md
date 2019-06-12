# HTML

## day02

* audio / movie

  ```html
  - <!DOCTYPE html>
    <html>
    <head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    </head>
    <body>
    <h1>Audio Test</h1>
    <audio src="file/Kalimba.mp3" controls="controls">
    Not Support
    
    </audio>
    
    <video src="http://media.w3.org/2010/05/bunny/movie.ogv" controls="controls">
    </video>
    </body>
    </html>
  
  
  ```

* div / span

  block은 width와 height를 줄 수 있음

  block의 대표적인 tag => div

  inline의 대표적인 tag => span

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <style>
  div{
  	background: blue;
  	width:500px;
  	height:50px;
  	color:yellow;
  }
  span{
  	color:red;
  }
  </style>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>DIV TEST</h1>
  <div>Block <span>Area</span> Blue Zone..</div>
  </body>
  </html>
  ```

  

<https://getbootstrap.com/>

<https://bootstrapmade.com/demo/Eterna/>



* form

  여러개를 한곳으로 보낼 수 있다.

  ```html
  <!-- form1.html-->
  
<!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <script>
  function login(f){
  	var c = confirm('Are You Login ...');
  	if(c == true){
  		f.method = 'GET';
  		f.action = 'a';
  		f.submit();
  		<!-- a에 GET방식으로 날리겠다 -->
  	};
  };
  </script>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>Form Test</h1>
  <form action="a" method="GET"><!-- a서버에 GET방식으로 서버에 전송할 것이다. -->
  ID <input type="text" name="nm"><!-- type은 text형, name은 서버 전송할 때 쓰임 --><br>
  PWD <input type="password" name="pwd" required pattern="[0-9]+[a-zA-Z]+[~!@\#$%<>^&*]"><br>
  <input type="reset" value="RESET">
  <input onclick="login(this.form);"
  type="button" value="LOGIN">
  </form>
  </body>
  </html>
  <!-- http://70.12.50.238/day02/a?nm=a&pwd=a
  	a서버에 nm과 pwd를 보냄 -->
  ```
  
  ```html
  <!-- form2.html -->
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  </head>
  <body>
  <h1>Form List</h1>
  
  <form>
  <fieldset>
  <legend>Employee Register</legend><!-- 큰 박스 테두리 -->
  <input type="hidden" name="geo" value="">
  TEXT <input type="text" name="tx"><br>
  PASSWORD <input type="password" name="pwd"><br>
  <label for="male">Male</label><!-- male를 위해 label을 쓴다 -->
  <input id="male" type="radio" name="g" value="m">
  Female <input type="radio" name="g" value="f">
  Aje <input type="radio" name="g" value="a">
  <hr>
  Apple<input type="checkbox" name="f" value="a">
  Grape<input type="checkbox" name="f" value="g">
  Orange<input type="checkbox" name="f" value="o">
  Mellon<input type="checkbox" name="f" value="m">
  <!-- checkbox는 여러개를 선택할 수 있다. --><hr>
  <select name="car">
  	<option value="h">Hyndai</option>
  	<option value="k">Kia</option>
  	<option value="s">SSang</option>
  	<option value="c">Chev</option>
  </select>
  <hr>
  File <input type="file" name="ff">
  <hr>
  <input type="button" value="Button"><!-- 의미없는 버튼 -->
  <hr>
  <input type="submit" value="SUBMIT"><!-- 서버로 전송되는 버튼 -->
  </fieldset>
  </form>
  </body>
  </html>
  ```
  
  ```html
  <!-- form3.html -->
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  </head>
  <body>
  <h1>HTML5 Form</h1>
  <form>
  Level<input value="level1" type="text" name="nm" readonly="readonly"><br><!-- readonly는 value가 있어야함 -->
  DATE<input type="date" name="d"><br>
  COLOR<input type="color" name="c"><br>
  EMAIL<input type="email" name="e" ><br>
  TEL<input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" name="e" required><br>
  NUMBER<input type="number" name="num"><br>
  Range<input type="range" min="1" max="10" name="ragne"><br>
  <input type="submit" value="REGISTER">
  
  </form>
  </body>
  </html>
  ```
  
  