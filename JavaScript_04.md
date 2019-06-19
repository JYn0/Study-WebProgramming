# JavaScript

## day07

```html
j8.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function c1(){
	var h1 = document.getElementById('h1').innerText; // => id==h1값의 text 가져오기
	alert(h1);
	document.getElementById('h1').innerText = h1 + 'ADD TEXT'; // => id==h1에 값을 넣기

	var id = document.getElementById('id').value; // id==id 값 가져오기
	alert(id);
	document.getElementById('id').value = id + 'ADD ID';
};
</script>
</head>
<body>
<h1 id="h1">Header</h1>
ID<input id="id" type="text" name="id"><br>
<button onclick="c1();">Click1</button> <!-- c1을 클릭하면 위의 두 정보를 가져온다  -->
</body>
</html>
```



```html
j9.html


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function add(){
	// var id = document.myform.id.value; // ID 값 가져오기
	var id = document.myform.study;
	for(var i in id){
		if(id[i].checked){
			alert(id[i].value);
		}
	}
};
</script>
</head>
<body>
<form name="myform">
	ID<input type="text" name="id"><br>
	STUDY<input type="checkbox" name="study" value="s">
	MUSIC<input type="checkbox" name="study" value="m">
	TRAINING<input type="checkbox" name="study" value="t"><br>
	<input type="button" value="ADD" onclick="add();">
</form>
</body>
</html>
```

