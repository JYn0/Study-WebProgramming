# CSS3

## day_03

### 박스

* 박스모델

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <style>
  /* Global CSS */
  *{
  	margin:0;
  	padding:0;
  }
  a{
  	text-decoration: none;
  	color:black;
  }
  /* div CSS */
  div{
  	margin:10px auto;/* 위아래 좌우 */
  	width:500px;
  	height:300px;
  	border:2px solid black;
  	background: gray;
  	/* padding:50px; */
  }
  div > a{
  	display:block;/* box안에 box가 들어감 */
  	font-size: 2em;
  	/* margin: 50px; *//* 자기 중심의 margin 생성 */
  	border: 10px solid red;
  	width:100px;
  	margin:10px auto;
  }
  </style>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  </head>
  <body>
  <div>
  <a href="">Click</a>
  </div>
  </body>
  </html>
  ```

  

<https://fonts.google.com/>

