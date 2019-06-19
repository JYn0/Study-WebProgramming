# JavaScript

## day07

*  반복문

  ```html
  j1.html
  

  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
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
  function getData(){
  	var data = document.getElementById('data');
  	var result = '';
  	for(var i=0; i<person.length; i++){
  		result += '<h2>'+ person[i].id+" "+person[i].name + '</h2>';
  	};
  	data.innerHTML = result;
  
  	// table
  	result += '<table border="2">';
  	result += '<tbody>';
  	for(var i in person){ //i는 0부터 배열 사이즈까지 증가 //var i=0; i<person.length; i++
  		result += '<tr>' 
  			+ '<td>' + person[i].id+'</td>'
  			+ '<td>' + person[i].name + '</td>' 
  			+ '</tr>';
  	};
  	result += '</table>';
  	result += '</tbody>';
  	data.innerHTML = result;
  };
  </script>
  </head>
  <body>
  <h1 onclick="getData();">FOR TEST</h1><!-- For TEst 누르면 getData함수 호출 -->
  <div id="data"></div><!-- data뿌리기 -->
  </body>
  </html>
  ```
  
  

* 함수

  ```html
  j2.html
  
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  <style></style>
  <script>
  // 함수 선언1
  function a(){ // 함수에는 return과 argument가 없다 => type은 var뿐이라서
  	alert('a');
  
  };
  a();
  // 함수 선언2
  var b = function(){
  	alert('b');
  };
  b();
  </script>
  </head>
  <body>
  
  </body>
  </html>
  
  
  
  <script>
  function a(i){
  	return 10*i;
  };
  function b(){
  	return 20;
  };
  function c(i,j){
  	var result = i(2) + j();
  	return result;
  };
  
  var data = c(a,b); // a(2)를 하면 값이 되어버림, 함수X
  alert(data);
  var data = c(a,function(){
  	return 500;
  });
  </script>
  
  
  
  <script>
  function a(i){
  	return 10*i;
  };
  function b(){
  	return 20;
  };
  function c(i,j){
  	var result = i(2) + j();
  	return result;
  };
  
  var data = c(a,function(){
  	return 500;
  });
  // alert(data);
  
  // setInterval(b,3000); //3초에 한번씩 b함수 실행
  
  // setInterval(function(){
  // 	alert('Hi');
  // },3000); // 3초에 한번씩 함수 실행 -> 함수에 함수(argu)를 넣는경우
  
  var f1 = function(){
  	return function(i){
  		return 100*i;
  	};
  };
  var f2 = f1(); //f2는 함수
  var result = f2(2);
  alert(result);
  </script>
  
  <script>
  var c = prompt('Input your Name...','James');//James : default
  </script>
  ```

  

* d