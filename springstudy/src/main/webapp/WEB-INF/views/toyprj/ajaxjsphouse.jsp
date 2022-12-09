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
					<div id="first"></div>
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

	// 컨트롤러에서 넘어온 변수를 저장할 값
	// 자바스크립트 배열 선언방식.
	
	
	/* let list3 = [{'cardList': 'spade', 'cardList2':'clover'}]; */
	let firstList = [];
		let secondList = [];
	function openCard() {
		
		var list = [];
		var list2 = [];
		
		$.ajax({
			// ajax안에 있는 코드들은 맵이다
			// type (키) : 값;
			type : 'POST',
			url : "/ajaxjspdobak",
			data : {
				// 여기서 데이터를 넘겨야함.
				"first" : JSON.stringify(firstList),
				"second" : JSON.stringify(secondList)
			},
			datatype : "JSON",
			success : function(obj) { // <= success 부분의 obj 저 부분이 컨트롤러(서버)의 return값이 들어가는 부분이다.

				if (obj.connect == "success") {
					for (var i = 0; i < obj.cardList.length; i++) {
						// 객체의 길이를 구하는 방법은 따로있다.
						// Object.keys(객체의 변수명).length이다.

						list.push((i + 1) + "번째 패 : " + obj.cardList[i].cardNum
								+ "<br/>");
						console.log(obj.cardList[i].cardNum);
						// 배열에 값을 넣어줄때는 배열명.push(넣을 값); 으로 선언한다.
					}

				}
				if (obj.connect2 == "success2") {
					for (var i = 0; i < obj.cardList2.length; i++) {
						/* 위 조건문의 객체의 길이는 객체 전체의 길이다. 나는 카드를 4장을 넣었고 그러므로 객체의 길이는 총 4가 되어버린다.
						cardlist의 길이를 따로 뽑을순 없을까? 하면서 데브툴즈로 만지작 거리다 obj.cardList.length의 방식으로 선언이
						가능함을 알았다. ****원래의 오브젝트 배열 길이 뽑는법 : Object.keys(obj).length 이런식.**** */
						list2.push((i + 1) + "번째 패 : "
								+ obj.cardList2[i].cardNum + "<br/>");
						console.log(obj.cardList2[i].cardNum);
					}
				}
				// 엄청난 console.log의 흔적이다. console.log를 생활화 하자. 꼭 
				// console.log(list);
				// console.log(list2);
				// console.log(obj);
				
				// console.log(Object.keys(obj).length);
				firstList.push(list);
				secondList.push(list2);
				console.log(firstList);
				console.log(secondList);
				
				$("#first").html(list);
				$("#second").html(list2);
				$("#result").html(obj.result);

				/*  var firstResult = document.getElementById("first");
				firstResult.innerHTML = list; */

			},
			error : function(request, status, error) { // 결과 에러 콜백함수
				console.log(error);
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