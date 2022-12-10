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
	
	console.log(cardData1);
	console.log(cardData2);
	// 객체화 테스트 출력 ok
	
	function openCard() {
		// 딜러의 카드를 담아서 넘겨버릴 배열변수 선언.
		var list2 = [];
		
		$.ajax({
			// ajax안에 있는 코드들은 맵이다
			// type (키) : 값;
			type : 'POST',
			url : "/ajaxjspdobak",
			data : {
				// 여기서 데이터를 넘겨야함.
				'first' : JSON.stringify(cardData1),
				'second' : JSON.stringify(cardData2),
			},
			datatype : 'JSON',
			success : function(data) { // <= success 부분의 obj 저 부분이 컨트롤러(서버)의 return값이 들어가는 부분이다.

				 if (data.connect == "success") {
					 // 아랫부분은 굳이 필요가 없었던 for문이였음. 플레이어의 카드는 첫 출력 후 변하지 않음. => 주석처리.
					 
					/* for (var i = 0; i < data.cardList.length; i++) {
						// 객체의 길이를 구하는 방법은 따로있다.
						// Object.keys(객체의 변수명).length이다.

						list.push((i + 1) + "번째 패 : " + data.cardList[i].cardNum
								+ "<br/>");
						console.log(data.cardList[i].cardNum);
						// 배열에 값을 넣어줄때는 배열명.push(넣을 값); 으로 선언한다.
					}  */
					
					for (var i = 0; i < data.cardList2.length; i++) {
						/* 위 조건문의 객체의 길이는 객체 전체의 길이다. 나는 카드를 4장을 넣었고 그러므로 객체의 길이는 총 4가 되어버린다.
						cardlist의 길이를 따로 뽑을순 없을까? 하면서 데브툴즈로 만지작 거리다 obj.cardList.length의 방식으로 선언이
						가능함을 알았다. ****원래의 오브젝트 배열 길이 뽑는법 : Object.keys(obj).length 이런식.**** */
						list2.push((i + 1) + "번째 패 : "
								+ data.cardList2[i].cardNum + "<br/>");
						console.log(data.cardList2[i].cardNum);
					}

				}
				
				// 엄청난 console.log의 흔적이다. console.log를 생활화 하자. 꼭 
				// console.log(list);
				// console.log(list2);
				// console.log(obj);
				
				// console.log(Object.keys(obj).length);
				/* firstList.push(list);
				secondList.push(list2); */
				
				/* console.log(list); */
				/* console.log(list2); */
				
				/* $("#first").html(list); */
				
				$("#second").html(list2);
				$("#result").html(data.result);
				document.getElementById("open").style.display="none";

				/*  var firstResult = document.getElementById("first");
				firstResult.innerHTML = list; */

			},
			error : function(request, status, error) { // 결과 에러 콜백함수
				console.log(error);
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