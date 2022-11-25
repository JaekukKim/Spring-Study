<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비닐하우스</title>

<style>
thead {
	background-color: green;
}

#first, #second {
	text-align: center;
}
</style>

</head>
<body>
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
	<table border="1">
		<thead>
			<!-- 테이블 태그는 table-thead-tr-th-tbody-tr-td 순으로 작성해준다 조금 까다롭다. -->
			<tr>
				<th>1번째 패</th>
				<th>2번째 패</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<div id="first">${first }</div>
				</td>
				<td>
					<div id="second">${second }</div>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button id="result" type="button" onclick="result()">결과확인</button>
	</div>
</body>
</html>