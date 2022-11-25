<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CDN을 따올때는 헤드부분에만 스크립트를 넣자. 여기다가 js 작성하지말고 body태그 안에다가 가급적 작성하자... -->

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
					<button id = "first" onclick="firstSet()">1번째패</button>
				</td>
				<td>
					<button id = "second" onclick="secondSet()">2번째패</button>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button id="result" type="button" onclick="resultSet()">결과확인</button>
	</div>
</body>
<script>

		function firstSet(){
			//var first = document.getElementById("first");
			
			/* var fir = $("#first");
			fir.html(${first}); */
			$("#first").html(${first});
		}
		
		function secondSet(){
			//var second = document.getElementById("second");
			
			/* var sec = $("#second");
			sec.html(${second}); */
			$("#second").html(${second});
		}
		
		function resultSet(){
			var resultNum = (${first } + ${second }) % 10;
			
			//var result = document.getElementById("result");
			var res = $("#result");
			res.html(${result});
			
			
			if(${first } == ${second }){
				// result.innerHTML = ${first } + ' 땡입니다!!';
				res.html(${first } + ' 땡입니다!!');
				
			} else {
				res.html(resultNum + " 끗입니다.");
				
			}
			if(resultNum==0){
				res.html("망통이네요...");
				
			}
		}
</script>
</html>