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
					<div id="first"></div>
				</td>
				<td>
					<div id="second"></div>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<div id="result">결과확인</div>
	</div>
</body>
<script>
		/* document.ready()를 써야하는건 따옴, 이제 어떻게 이쁘게 작성할까... */
		/* 그 전 jshouse.jsp 에서 썼던 코드들 jquery + 리팩토링 */
		/* 스크립트 영역에서 전역변수를 따로 선언하고 <link src = "js파일경로명"/> 식으로 js파일을 임포트했을때 변수 명이 같은게 있는지
			반드시 확인해주어야한다. 이 부분은 정말정말 중요하다. 프론트영역이긴함.*/
			
		$(document).ready(function() {
			var firstHanded = ${first};
			var secondHanded = ${second};
			var totalHanded = (firstHanded+secondHanded) % 10;
			
			$("#first").html(firstHanded);
			$("#second").html(secondHanded);
			
			if(firstHanded == secondHanded){
				$("#result").html(firstHanded + ' 땡입니다!!');
				
			} else if (firstHanded != secondHanded){
				$("#result").html(totalHanded + " 끗입니다.");
				
			} else if (totalHanded==0) {
				$("#result").html("망통이네요..");	
			}
		});
		
</script>
</html>