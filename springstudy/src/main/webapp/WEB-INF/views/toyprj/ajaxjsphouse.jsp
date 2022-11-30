<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
	<!-- 자바코드 선언 -->

	<!-- 일단 위는 주석 -->
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
						<button id="first" onclick="firstCard()">1번 패 공개</button>
						<div id = "add">이곳에 공개됩니다.</div>
					</td>
					<td>
						<button id="second" onclick="secondCard()">2번 패 공개</button>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
			<div id="result"></div>
		</div>
		
</body>
<script type="text/javascript">

	// 1. 아래 변수 선언 위치도 제대로 모르고 선언함 ajax 코드 안에는 변수선언 하면 안됨.
	// 2. ajax안에 error를 지 맘대로씀
	// 3. 스크립트 에러나는데 개발자도구 1도안쳐다봄 (f12의 습관화)
	// 4. success에서 가져온 data console.log로 찍으면 되는데 시도 조차 안함.
	// (f12에서 브레이크포인트 사용이 가능하다 꼭 쓸것, 브레이크 포인트 쓰기 전 console.log() 겁나게 찍자 콘솔로그엔 답이있다..!)
	
	// 컨트롤러에서 넘어온 변수를 저장할 값
	// 자바스크립트 배열 선언방식.
	var card = 0;
	function firstCard(){
		$.ajax({
			// ajax안에 있는 코드들은 맵이다
			// type (키) : 값;
			type : 'POST',
			url : "/ajaxjspdobak",
			data : {"add" : card},
			datatype : "JSON",
			success : function (obj){
				
				var list = [];
				
				if (obj.connect == "success") {
					for (var i = 0; i < Object.keys(obj).length; i++) {
						// console.log(cardList);
						list.push(obj.cardList[i].cardNum);
						// console.log(cardList);
					}
				}
				console.log(list);
				console.log(obj);
				console.log(typeof obj);
				console.log(Object.keys(obj).length);
				document.getElementById("add").innerHTML = obj;
				
			},
			error : function(request, status, error) { // 결과 에러 콜백함수
		        console.log(error)
		    }
		});
	}
	/* ajax 코드 작성 */

	/* 
		ajax의 주 목적은 화면 전환 없이 클라이언트와 서버간의 정보를 교환하기 위함이다.
		원래의 정보처리 방식은 클라이언트(웹 브라우저) -> 서버 -> jsp였으나 ajax를 이용한다면
		클라이언트 -> 서버 -> ajax -> jsp -> 서버 -> 순환...후 클라이언트 이런식으로 돌아간다. 즉 ajax는 비동기식 통신 방식이다.
	 */

</script> 
</html>