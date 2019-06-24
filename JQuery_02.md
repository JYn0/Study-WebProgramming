# jQuery

## day09



```html
jq10.html



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>
$(document).ready(function(){
	$('textarea').keyup(function(){
		var str = $(this).val();
		$('h1').text(str.length);
		if(str.length >= 50){
			alert('max 50 character');
			$('h1').css('color','red');
		}
	});
});
</script>
</head>
<body>
<h1></h1><!-- textarea에 몇글자가 찍히는지 글자수 세기 -->
<textarea cols="50" rows="20"></textarea><!-- 열 / 줄  (픽셀아님) -->
</body>
</html>
```



```html
jq11.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
div{
	width:600px;
	border:3px solid red;
}
img{
	display:block;
	margin:10px 0;
}
</style>
<script>
function getData(){
	for(var i=0;i<10;i++){
		var img = '<img src="sp.jpg">';
		$('div').append(img);
	}
	$(window).scroll(function(){
		var scTop = $(window).scrollTop();
		var docH = $(document).height(); // 문서의 높이
		var winH = $(window).height(); // window 높이
		console.log(docH+' '+winH+' '+scTop);

		if(docH <= winH+scTop+30){
			getData();
		}
	});

	
};
$(document).ready(function(){
	getData();
});
</script>
</head>
<body>
<div></div>
</body>
</html>
```

