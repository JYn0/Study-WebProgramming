# jQuery

## day09



* <https://jquery.com/> - Download - jQuery - [Download the compressed, production jQuery 3.4.1](https://code.jquery.com/jquery-3.4.1.min.js) - day09/web/jquery 저장 => jQuery를 서버에 탑재

* https://jquery.com/> - Download - GoogleCDN - jQuery - <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> - 1.x snippet

일종의 자바스크립트 라이브러리(언어 X)

모든 브라우저는 javaScript library를 갖고있다



```html
jq1.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="jquery/jquery.min.js"></script> <!-- jQuery 로딩 -->
<style></style>
<script>
window.onload = function(){ // 페이지 로딩되고 바로 실행
 	$('h1').text('OK');
};

</script>
</head>
<body>
<h1>Header1</h1>
</body>
</html>
```



```html
jq2.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){ //$()가 준비되면 ready()를 실행해라 
	var txt = $('h1').text(); // h1을 가져오기
	alert(txt); 
	$('h1').text('-----'); // 뿌리기
	$('#hh').html('<a href="">Clcik</a>'); // id 가져오기
	$('.ch').text('Class');
	$('input[type="text"]').css('background','gray');
	$('input[name="pwd"]').css(
		{'color':'red', 'background':'blue'} // JSON
	);
});
</script>
</head>
<body>
<h1>Header1</h1>
<h1 id="hh">Header1</h1>
<h1>Header1</h1>
<h1 class="ch">Header1</h1>
<input type="text" name="id"><br>
<input type="password" name="pwd"><br>
</body>
</html>
```





* eq / not	

```html
jq3.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){ // document가 다 뿌려지면 함수를 실행한다
	//$('h1:first-child()').css('color','red');
	//$('h1:nth-child(2n)').css('color','red');
	$('h1:eq(0)').css('color','red'); // == ('h1').eq(0).css('color','red');
	$('h1:nlt(h1.eq(3))').css('color','red'); // not 빼고 
});
</script>
</head>
<body>
<h1>Header1</h1>
<h1>Header2</h1>
<h1>Header3</h1>
<h1>Header4</h1>
<h1>Header5</h1>
</body>
</html>
```



```html
jq4.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){
	$('table').css({
		border : '1px solid black'
	});
	$('thead').css('color','red');
	$('tr:nth-child(2n)').css('color',"pink");
	$('tbody>tr:even').css(
		{'background-color':'black', 'color':'white'}
	);

});
</script>
</head>
<body>
<h1>Table</h1>
<table>
	<thead>
		<tr><th>ID</th><th>NAME</th></tr>
	</thead>
	<tbody>
		<tr><th>id01</th><th>James</th></tr>
		<tr><th>id02</th><th>James</th></tr>
		<tr><th>id03</th><th>James</th></tr>
		<tr><th>id04</th><th>James</th></tr>
		<tr><th>id05</th><th>James</th></tr>
	</tbody>

</table>
</body>
</html>
```





```html
jq5.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){
	// $('a').click(function(){ // a에 click이 일어나면 함수 실행
	// 	$('button').hide();
	// 	alert('A');
	// }); 
	$('a:first').click(function(){
		$('button').hide();
	});
	$('a:last').click(function(){
		$('button').show();
	});
	$('a').hover(function(){ // mouseenter <-> mouseleave
		$('h1').text('Mouse Enter');
	}, function(){
		$('h1').text('Mouse Leave');
	});

	$('input').bind( // 여러개의 event
		{	// 여러개의 object(JSON)
			focus:function(){ // 들어올때
				$(this).css('background','gray'); //this -> input
			},
			keyup:function(){ // <-> keydown(press)
				alert($(this).val()); // input에입력한 값을 val로 가져와 alert로 띄우기
			},
			blur:function(){ // 나올때(검사)
				$(this).css('background','white');
			}
		});
});
</script>
</head>
<body>
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<h1></h1>
<a href="#">HIDE</a>
<a href="#">SHOW</a>
<button>Click</button>
<button>Click</button>
<button>Click</button>
<button>Click</button>
<button>Click</button>
</body>
</html>
```



```html
jq6.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){
	$('a').click(function(){
		var id = $('#rf > input[name="id"]').val();
		var pwd = $('#rf > input[name="pwd"]').val();
		var name = $('#rf > input[name="name"]').val();
		var c = confirm('Are you ok?');
		if(c = true){
			$('#rf').attr('method','get');
			$('#rf').attr('action','a.jsp');
			$('#rf').submit();
		}
	});

	$('#rf > input[name="id"').blur(function(){ // input하고 끝나면 가져와라
		var id = $('#rf > input[name="id"]').val();
		
	});
});
</script>
</head>
<body>
<h1>Register</h1>
<form id="rf">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
NAME<input type="text" name="name"><br>
<a href="#">REGISTER</a>
</form>
</body>
</html>
```



```html
jq7.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){
	$('img').css('position','relative'); //css('display','none')
	$('button').click(function(){
		$('img').animate( //show() toggle('slow')
			{
				left:'300px',
				opacity:'0.5',
				width:'250px'
			}
		); 
	});
});
</script>
</head>
<body>
<button>Click</button>
<img src="suki.PNG">
</body>
</html>
```



```html
jq8.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
div{
	width:400px;
	border:3px solid blue;
	margin-top: 50px;
}
.hh{
	color:red;
	font-size: 1.2em;
	background: pink;
}
.dd{
	width:200px;
	border:3px dotted red;
	background: blue;
}
</style>
<script>
var cnt = 0;
$(document).ready(function(){
	$('button:eq(0)').click(function(){
		$('div').append('<h3>Append'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(1)').click(function(){
		$('div').prepend('<h3>Prepend'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(2)').click(function(){
		$('div').after('<h3>After'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(3)').click(function(){
		$('div').before('<h3>Before'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(4)').click(function(){
		$('div').empty();
		cnt++;
	});
	$('button:eq(5)').click(function(){
		$('div').remove();
		cnt++;
	});
	$('button:eq(6)').click(function(){
		$('div').addClass('dd');
		$('h1').addClass('hh');
	});
	$('button:eq(7)').click(function(){
		$('div').removeClass('dd');
		$('h1').removeClass('hh');
	});
});
</script>
</head>
<body>
<h1>DOM Management</h1>
<button>Append</button>
<button>Prepend</button>
<button>After</button>
<button>Before</button>
<button>Empty</button>
<button>Remove</button>
<button>ADD CLASS</button>
<button>REMOVE CLASS</button>
<div></div>
</body>
</html>
```



```html
jq9.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
//var d = ['a','b','c','d','e'];
var person = [ 
	{img:'suki.PNG',id:"id01", name:"무지"},
	{img:'akiya.PNG',id:"id02", name:"콘"},
	{img:'kakaoryan.jpg',id:"id03", name:"라이언"},
	{img:'m00.png',id:"id04", name:"어피치"},
	{img:'bk.jpg',id:"id05", name:"네오"}
	
]

$(document).ready(function(){
	// $(d).each(function(idx,item){ // 배열 d for문 : function함수가 6번 호출됨
	// 	alert(idx+' '+item); //0 a -> 1 b -> 2 c -> 
	// });
	// $('div').html

	// var result = '';
	// $(person).each(function(idx, item){
	// 	result += '<h1>'+item.id+' '+item.name+'</h1>'; 
	// });
	// $('div').html(result);

	
	$(person).each(function(idx, item){
		var result = '';
		result = '<img src="'+item.img+'">'+item.id+' '+item.name+'<br>'; 
		$('div').append(result);
	});
	
});
</script>
</head>
<body>
<div></div>
</body>
</html>
```

