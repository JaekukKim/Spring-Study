<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비닐하우스</title>
	<script>
		function first(){
			var first = document.getElementById("first");
			first.innerHTML = ${first };
		}
		function second(){
			var second = document.getElementById("second");
			second.innerHTML = ${second };
		}
		function result(){
			var resultNum = (${first } + ${second }) % 10;
			var result = document.getElementById("result");
			
			if(${first } == ${second }){
				result.innerHTML = ${first } + ' 땡입니다!!';
			} else {
				result.innerHTML = resultNum + " 끗입니다.";
			}
			if(resultNum==0){
				result.innerHTML= "망통이네요....";
			}
		}
	</script>
</head>
<body>
	<table border = "1">
		<th bgcolor="yellow">1번째 패</th>
		<th bgcolor="yellow">2번째 패</th>
			<tr>
				<td>
					<button type = "button" onclick="first()" id="first">1번째 패 확인</button>
				</td>
				<td>
					<button type = "button" onclick="second()" id="second">2번째 패 확인</button>
				</td>
			</tr>
	</table>
	<div>
		<button id = "result" type = "button" onclick="result()">결과확인</button>
	</div>
</body>
</html>