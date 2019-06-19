# JavaScript

## day07

### 자바스크립트 객체

```html
j4.html


<script>
var Car = {
	name:'K1',
	size:1000,
	go:function(){
		return this.name+' Go';
	},
	stop:function(){
		return this.name+' Stop';
	}
};
var result = Car.go();
alert(result);
var d = new Date();
// JavaScript Class
function Person(name, age){
	this.name = name;
	this.age = age;
	// this.print = function(){
	// 	return this.name+' '+this.age;
	// };
};
Person.prototype.print = function(){
	alert(this.name+' '+this.age);
};
var p1 = new Person('James', 30); //생성
var p2 = new Person('Tom', 20);
// 객체가 아무리 많이 만들어져도 객체(prototype)는 한번만들어진다
p1.print();
</script>
```

```html
j5.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var person = [ 
	{id:"id01", name:"무지"},
	{id:"id02", name:"콘"},
	{id:"id03", name:"라이언"},
	{id:"id04", name:"어피치"},
	{id:"id05", name:"네오"}
]

function getdata(){
	for(var i in person){
		person[i].print = function(){
			return '<h2>' + this.id+' '+this.name + '</h2>';
		};
	}

	var div = document.getElementById('div');
	var result = '';
	for(var i in person){
		result += person[i].print();
	}
	div.innerHTML = result;
};
</script>
</head>
<body>
<h1 onclick="getdata();">Click</h1>
<div id="div"></div>
</body>
</html>


<script>
var Sk = {
	data:10,
	a:function(){ alert('sk');}
};
var Hb = {
	data:20,
	a:function(){ alert('hb');}
};
Sk.a();

// // 함수이름이 같아도 에러는 안뜸
// function a(){ alert('a');};
// function a(){ alert('aa');};
// a();
</script>
```

```html
j6.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var t = function(){
	var time = document.getElementById('time');
	var result = '';
	var date = new Date();
	result = date.toLocaleTimeString();

	time.innerHTML = result;
};
setInterval(t,1000);
</script>
</head>
<body>
<h1 id="time"></h1>
</body>
</html>
```



```html
j7.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var c =null;
try{
	c = new Daate();
}catch(error){
	alert('Network Error...');
}
alert(c);
</script>
</head>
<body>
<h1>Exception</h1>
</body>
</html>
```

