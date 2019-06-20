# JavaScript

## day08



```html
j1.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
window.onload = function(){ // body가 모두 출력되면 자동으로 실행
	var h1 = document.getElementById('h1');
	var h2 = document.getElementById('h2');
	var h3 = document.getElementById('h3');

	var s1 = setInterval(function(){
		var txt = h1.innerText;
		h1.innerText += txt+'*';
	},200); // 0.2초에 한번씩 function 실행
	var s2 = setInterval(function(){
		var txt = h2.innerText;
		h2.innerText += txt+'*';
	},500); 
	var s3 = setInterval(function(){
		var txt = h3.innerText;
		h3.innerText += txt+'*';
	},400);
	
	setTimeout(function(){
		clearInterval(s1);
		clearInterval(s2);
		clearInterval(s3);
	},5000); // 5초가 지나면 모두 stop

};
</script>
</head>
<body>
<h1>Interval Test</h1>
<h1 id="h1"></h1>
<h1 id="h2"></h1>
<h1 id="h3"></h1>

</body>
</html>
```



```html
j2.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function go(){
	var url = 'j1.html';
	var newWindow = window.open(url,'',resize=1, scrollbar=1,status=1);
	newWindow.moveTo(0,0);
	newWindow.resizeTo(screen.availWidth, screen.availHeight);
};
function go2(){
	var c = confirm('Are You Go to ...');
	if(c == true){
		location.href='j1.html';
	}
};
</script>
</head>
<body>
<a href="#" onclick="go();">Click</a>
<a href="#" onclick="go2();">Click</a>
</body>
</html>
```

