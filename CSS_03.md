# CSS3

## day_04

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
div{
	width:300px;
	height:100px;
}
#d1{
	background: red;
}
#d2{
	background: blue;
	/* position: relative; /* 주변 box 기준 */ 
	/* position: absolute; /* 속한 body 기준 */ 
	position: fixed; /* 특정위치에 고정, 스크롤되어도 움직이지않음 */
	left: 50px;
	top: 20px
}
#d3{
	background: green;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="d1">div1</div>
<div id="d2">div2</div>
<div id="d3">div3</div>
<div id="d3">div3</div>
<div id="d3">div3</div>
<div id="d3">div3</div>
<div id="d3">div3</div>
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
div{
	width:100px;
	height:100px;
	float:left;/* 좌정렬 */
}
#d1{
	background: red;
}
#d2{
	background: blue;
}
#d3{
	background: green;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="d1">div1</div>
<div id="d2">div2</div>
<div id="d3">div3</div>
<div id="d1">div1</div>
<div id="d2">div2</div>
<div id="d3">div3</div>
<div id="d1">div1</div>
<div id="d2">div2</div>
<div id="d3">div3</div>
<!-- div123을 div로 한번더 감싸면 3X3을 만들 수 있따 -->
</body>
</html>
```



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
#out{
	border:1px solid black;
	width:200px;
	height:200px;
	overflow: auto;/* scroll hidden */
}
#d1, #d2, #d3{
	width:100px;
	height:100px;
	opacity:0.9;
}
#d1{
	background: red;
	z-index: 100;
}
#d2{
	background: blue;
	left:30px;
	top:30px;
	z-index: 10;
}
#d3{
	background: green;
	left:60px;
	top:60px;
	z-index: 1;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="out">
<div id="d1">div1</div>
<div id="d2">div2</div>
<div id="d3">div3</div>
</div>

</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
ul,ol{
	list-style: none;
}

header, section, footer{
	margin:0 auto;
}
/* Header CSS */
header{
	width:800px;
	height:200px;
	background: pink;
	position: relative;
}

header > #top_nav{
 	position: absolute;
	height: 30px;
	width:200px;
	right:1px;
	top:1px;
	font-size:0.6em;
}
header > hgroup{
	height: 80px;
	padding-top: 50px;
	text-align: center;
	font-size: 1.3em;
}

header > #main_nav{
	width:400px;
	margin:0 auto;
	height:40px;
	font-size: 1.3em;
}

header > #top_nav > ul > li{
	float:left;
	margin:0 5px;/* 글자 간의 간격 띄우기 => li사이의 간격 */
}
header > #main_nav > ul > li{
	float:left;
	margin:0 20px;
}

/* Section CSS */
section{
	width:800px;
	height:500px;
	background: gray;
}
#left_aside{
	float:left;
	width:150px;
	height:500px;
	background: green;
}
#center_aside{
	float:left;
	width:550px;
	height:500px;
	background: white;
}
#right_aside{
	float:left;
	width:100px;
	height:500px;
	background: gray;
}
#right_aside > img{
	margin:5px 10px;
}

/* Footer CSS */
footer{
	width:800px;
	height:50px;
	background: black;
}


</style>
<title>Insert title here</title>
</head>
<body>
<!-- id부여할 필요 없는 div -->
<header>
	<nav id="top_nav">
		<ul>
			<li><a href="">LOGIN</a></li>
			<li><a href="">REGISTER</a></li>
			<li><a href="">ABOUT US</a></li>
			<li><a href="">MAP</a></li>
		</ul>
	</nav>
	
	<hgroup><h1>W3C School</h1></hgroup>
	
	<nav id="main_nav">
		<ul>
			<li><a href="">HTML5</a></li>
			<li><a href="">CSS3</a></li>
			<li><a href="">AJAX</a></li>
			<li><a href="">jQuery</a></li>
		</ul>
	</nav>
</header>

<section>
	<aside id="left_aside"></aside>
	<aside id="center_aside"></aside>
	<aside id="right_aside">
		<img src="https://via.placeholder.com/80x150">
		<img src="https://via.placeholder.com/80x150">
		<img src="https://via.placeholder.com/80x150">
	</aside>
</section>
<footer></footer>
</body>
</html>
```

