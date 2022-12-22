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
				<th>플레이어</th>
				<th>딜러</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<div id="first">1번째 패 : ${firstCard}<br>
									2번째 패 : ${secondCard}</div>
				</td>
				<td>
					<div id="second">딜러의 패는 승부판정과 동시에 오픈됩니다.</div>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button id="open" onclick="openCard()">승부내기</button>
		<div id="result">결과는 ?</div>
	</div>
	<div id="turn">게임 회차 : ${pageCount }</div>

</body>
<script type="text/javascript">

	// 1. 아래 변수 선언 위치도 제대로 모르고 선언함 ajax 코드 안에는 변수선언 하면 안됨.
	// 2. ajax안에 error를 지 맘대로씀
	// 3. 스크립트 에러나는데 개발자도구 1도안쳐다봄 (f12의 습관화)
	// 4. success에서 가져온 data console.log로 찍으면 되는데 시도 조차 안함.
	// (f12에서 브레이크포인트 사용이 가능하다 꼭 쓸것, 브레이크 포인트 쓰기 전 console.log() 겁나게 찍자 콘솔로그엔 답이있다..!)
	
	// 파라미터를 js객체화
	let cardData1 = '${firstCard}';
	let cardData2 = '${secondCard}';
	
	// 컨트롤러에서 넘어온 pageCount(int타입)의 값을 여기서도 받아 카운팅 해주어야함.
	let pageCount = '${pageCount}';
	// 첫 접속 => pageCount 증가의 개념이니 1증가
	
	
	console.log('1차 pageCount 증가 값 : ' + pageCount);
	
	function openCard() {
		// 딜러의 카드를 담아서 넘겨버릴 배열변수 선언.
		var list2 = [];
		
		$.ajax({
			// ajax안에 있는 코드들은 맵이다
			// type (키) : 값;
			type : 'POST',
			url : "/securitydobak",
			data : {pageCount : pageCount},
			// ajax 통신이 진행될 때 서버로 넘어가는 데이터에 pageCount를 추가해주어 서버에서 받아서 검증이 가능하게 만들어야 한다.
			
			success : function(data) { // <= success 부분의 obj 저 부분이 컨트롤러(서버)의 return값이 들어가는 부분이다.
			
					for (var i = 0; i < data.cardList2.length; i++) {
						/* 위 조건문의 객체의 길이는 객체 전체의 길이다. 나는 카드를 4장을 넣었고 그러므로 객체의 길이는 총 4가 되어버린다.
						cardlist의 길이를 따로 뽑을순 없을까? 하면서 데브툴즈로 만지작 거리다 obj.cardList.length의 방식으로 선언이
						가능함을 알았다. ****원래의 오브젝트 배열 길이 뽑는법 : Object.keys(obj).length 이런식.**** */
						list2.push((i + 1) + "번째 패 : "
								+ data.cardList2[i].cardNum + "<br/>");
						console.log(data.cardList2[i].cardNum);
					}
				// 결과 데이터 (딜러의 패)를 화면에 출력하고 승부내는 버튼을 가린다.
				$("#second").html(list2);
				$("#result").html(data.result);
				document.getElementById("open").style.display="none";
				
				$("#turn").html('게임회차 : ' + pageCount);
				// 테스트출력을 반드시 해본다. 예상값은 2, 2가 안나온다면 뭔가뭔가있는거임.
				console.log('2차 pageCount 증가 값 : ' + pageCount);
			},
			error : function(request, status, error) { // 결과 에러 콜백함수
				alert('데이터 접근 불가');
			},
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