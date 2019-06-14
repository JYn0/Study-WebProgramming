# CSS3

## day_03

Web Programming -CSS3

HTML+CSS+JavaScript는 server에 존재하고, 브라우저에 download되서 브라우저에서 실행



<https://www.highcharts.com/demo>



style을 html에서는 유지보수가 어려우므로 css로 옮긴다





```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	h1{
		color:red;
		background:black;
	}
	#h1{
		color:pink;
		background:blue;
	}
	
</style>
<title>Insert title here</title>
</head>
<body>
<h1>Header1</h1>
<h1 id="h1">Header1</h1>
<h1 class="cc">Header1</h1>
<h2 class="cc">Header2</h2>
<h2>Header2</h2>
<p class="cc">Paragraph</p>
<p>Paragraph</p>
</body>
</html>
```



* 선택자

  ```html
  타입 선택자
  
  선택자 그룹
  <style>
  h1,h2{ /* h1이라는 elements에 style를 준다*/
  	color:red;
  	background:black;
  }
  </style>
  
  전체 선택자
  <style>
  *{
  	border:3px solid black;
  }
  </style>
  
  클래스 선택자
  <style>
  .cc{
  	color:red;
  	background:gray;
  }
  .cc{
  	color:red;
  	background:gray;
  }    
  </style>
  
  아이디 선택자
  <style>
  #h1{
  	color:pink;
  	background:blue;
  }
  </style>
  	
  속성 선택자
  ```

  

* CSS를 삽입하는 방법

  ```html
  c1.html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <link type="text/css" rel="stylesheet" href="c1.css">
  <title>Insert title here</title>
  </head>
  ```

  ```css
  c1.css
  @charset "EUC-KR";
   	*{border:3px solid black;} 
  /* CSS Comments */
  	h1,h2{ /* h1이라는 elements에 style를 준다*/
  		color:red;
  		background:black;}
  	#h1{
  		color:pink;
  		background:blue;}
  	.cc{
  		color:red;
  		background:gray;}
  	
  	input[type="text"]{/* input의 type="text"만 가져오고 싶을때 */
  		background:yellow;}
  ```

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <style>
  	div{/* div 공통 */
  		border:1px solid black;	}
  	#div1 > h3{ /* div1밑에 h3 */
  		color:red;	}
  	#div2 > div > h3{ /* >이건 바로 밑에만 가능 / 이게 더 우선 */
  		color:blue;	}
  	/* #div2 h3{ /* div2밑에 있는 모든 h3 */
  		color:yellow; }
  	#div2 h3{
  		color:green; }
  </style>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>Selector</h1>
  <div id="div1">
  	<h3>Header3</h3>
  </div>
  
  <div id="div2">
  	<div>
  		<h3>Header3</h3>
  	</div>
  </div>
  </body>
  </html>
  ```

  

  ```html
  c3.html
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <link href="https://fonts.googleapis.com/css?family=Amatic+SC|Quicksand&display=swap" rel="stylesheet">
  <style>
  h1{
  	font-family: 'Quicksand', sans-serif;
  }
  h3{
  	font-family: 'Amatic SC', cursive;
  }
  a{ /* a(click)의 밑줄을 없애겠다  */
  	text-decoration: none;
  	color:black;
  }
  a:hover{ /* click에 커서를 두면 */
  	background:blue;
  	color:yellow;
  	font-size: 1.5em; /* 1.5배 */
  }
  input:focus{
  	background:pink;
  	border:1px solid black;
  }
  div > h3:nth-child(4) {
  	color:red;
  	font-family: 'Quicksand', sans-serif;
  }
  /* div > :not(.a) {
  	color:#81BEF7;
  	font-family: "Courier New",Times,serif;
  	/* OS폰트 사용하면 안된다, 웹폰트 사용하기!! */
  } */
  /* input:hover{
  	background: gray;
  	border:1px solid black;
  }
  h3:nth-child(2n){ 
  	color:red;
  }
  h3:nth-child(2n+1) {
  	color:blue;
  } */
  </style>
  <title>Insert title here</title>
  </head>
  <body>
  <h1>A Link</h1>
  <a href="#">Click</a>
  <input type="text">
  <div>
  	<h3>Header</h3>
  	<h3 class="a">Header</h3>
  	<h3 class="a">Header</h3>
  	<h3>Header</h3>
  	<h3>Header</h3>
  	<h3>Header</h3>
  	<h3>Header</h3>
  </div>
  </body>
  </html>
  ```

  * c3.html과 c3.css로 나누기

  * ```html
    c3.html
    
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="EUC-KR">
    <link href="c3.css" rel="stylesheet" type="text/css">
    
    <title>Insert title here</title>
    </head>
    <body>
    <h1>A Link</h1>
    <a href="#">Click</a>
    <input type="text">
    <div>
    	<h3>Header</h3>
    	<h3 class="a">Header</h3>
    	<h3 class="a">Header</h3>
    	<h3>Header</h3>
    	<h3>Header</h3>
    	<h3>Header</h3>
    	<h3>Header</h3>
    </div>
    </body>
    </html>
    ```

  * ```css
    c3.css
    
    @charset "EUC-KR";
    @import url('https://fonts.googleapis.com/css?family=Amatic+SC|Quicksand&display=swap');
    
    h1{
    	font-family: 'Quicksand', sans-serif;
    	text-shadow: 3px 3px 3px #FF0000;/* 가로 세로 그림자의길이 색 */
    }
    h3{
    	text-align:center;
    	font-family: 'Amatic SC', cursive;
    	font-size: 1.5em;
    	height: 200px;
    	line-height:200px;
    	border:1px solid red;
    }
    a{ /* a(click)의 밑줄을 없애겠다  */
    	text-decoration: none;
    	color:black;
    	line-height: 100px;/* inline에서 높이 넓힐때(여백이 커짐) */
    	border:1px solid black;
    }
    a:hover{ /* click에 커서를 두면 */
    	background:blue;
    	color:yellow;
    	font-size: 1.5em; /* 1.5배 */
    }
    input:focus{
    	background:pink;
    	border:1px solid black;
    }
    div > h3:nth-child(4) {
    	color:red;
    	font-family: 'Quicksand', sans-serif;
    }
    /* div > :not(.a) {
    	color:#81BEF7;
    	font-family: "Courier New",Times,serif;
    	/* OS폰트 사용하면 안된다, 웹폰트 사용하기!! */
    } */
    /* input:hover{
    	background: gray;
    	border:1px solid black;
    }
    h3:nth-child(2n){ 
    	color:red;
}
    h3:nth-child(2n+1) {
    	color:blue;
    } */
    ```
    
    
    