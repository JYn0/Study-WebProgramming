# JavaScript

## day06



서버에 존재하다가 브라우저로 내려와서 실행

* Node.js : 서버에서 동작, 간단한 트위터
* jQuery : 비공식
* JSON



* 내부 자바스크립트 : <head></head>사이
* 외부 자바스크립트 : 링크
* 인라인 자바스크립트 : <body></body> 사이, 지양하기



new - Other - JavaScript - JavaScript Source File

```html
j1.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script src="j1.js"></script><!-- 외부스크립트 -->
<script>
/* j1.js로 이동 */
</script>
</head>
<body>
	<h1 onclick="alert('OK');">JavaScript Test</h1>
</body>
</html>
```

```js
j1.js

/**
 * 2019.06.18
 */

alert('2');
alert('3');
 1초(1000)에 한번씩 함수를 실행해라 
setInterval(function(){
	var now = new Date();
	document.write(now);
},1000);
```



```html
j2.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
// var : 변수
// 1. number
var v1 = 10;
var v2 = 10.1;
// 2. boolean
var v3 = true; 
// 3. string
var v4 = 'abc';
var v5 = "abc";
// 4. JavaScript object
// JSON(JavaScript Object Notation)
var v6 = {name:'k1', size:1000, go:function(){}, stop:function(){}};
// 5. function
var v7 = function(){};/* 변수에 함수를 할당할수있음 */
// 6. array(object)
var v8 = [1,2,3,'a'];
// 7. undefined
var v9;
// 8. null(값이 들어오지않은 object)
var v10 = null;

alert(typeof(v10));
</script>
</head>
<body>

</body>
</html>
```



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
var a = 10;
var b = '20';

/* alert(a+parseInt(b)); */
alert(String(a));
alert(a*b);
 
</script>
</head>
<body>

</body>
</html>
```





```html
j4.html


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

</style>
<script>
function calc(){
	var num1 = document.getElementById('n1').value;
	/* num1:Element, document:문서에서 가져와라 */
	var num2 = document.getElementById('n2').value;
	var sum = Number(num1) + Number(num2);
	var r = document.getElementById('result');
	r.style.color = 'red';
	/* r.innerHTML = '<a href="">' + sum + '</a>'; */
	r.innerHTML = sum;
	var rr = document.getElementById('rr');
	rr.value = sum;/* input form */
}
</script>
</head>
<body>
<form>
NUMBER1<input type="number" id="n1"><br>
NUMBER2<input type="number" id="n2"><br>
Result<input readonly="readonly" type="number" id="rr"><br>
<input type="button" value="Calc"
onclick = "calc();">
</form>
<h1 id="result"></h1>
</body>
</html>



<script>
function calc(){
	var num1 = document.getElementById('n1').value;
	/* num1:Element, document:문서에서 가져와라 */
	var num2 = document.getElementById('n2').value;
	var sum = Number(num1) + Number(num2);
	var r = document.getElementById('result');
	r.style.color = 'red';
	
	if(isNaN(sum)){/* Number 아니면 */
		r.innerHTML = '0';
	}else{
		r.innerHTML = sum;
	}
	
	var rr = document.getElementById('rr');
}
</script>
```

```html
j5.html


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
input[type="text"]:focus{
	background:gray;
}
</style>
<script>
function login(f){
	var id = f.id.value;
	var pwd = f.pwd.value;
	
	if(id == '' || id == null){
		alert('ID is Madatory field !');
		f.id.focus();
		return;/* 함수 끝내기 */
	}
	if(pwd == '' || pwd == null){
		alert('PWD is Madatory field !');
		f.pwd.focus();
		return;
	}
	
	// PWD가 4자리 이상이어야 함
	if(pwd.length < 4){
		alert('Input 4 character');
		f.pwd.focus();
		return;		
	}
	
	var c = confirm('Are you Login ?');
	if(c == true){
		f.submit();
	}
}
</script>
</head>
<body>
<form action="login" method="get">
ID<input type="text" name="id"><br>
PWD<input type="text" name="pwd"><br>
<input onclick="login(this.form);" type="button" value="login">
</form>
</body>
</html>
```

