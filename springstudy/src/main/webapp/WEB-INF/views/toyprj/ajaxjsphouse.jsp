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
						<button id="first" onclick="reStart()">ajax 버튼</button>
						<div>${first }</div>
					</td>
					<td>
						<div id="second"></div>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
			<div id="result"></div>
		</div>
		<button id="redraw" onclick="reDraw()">재시작</button>
		
</body>
<script type="text/javascript">
	/* ajax 코드 작성 */

	/* 
		ajax의 주 목적은 화면 전환 없이 클라이언트와 서버간의 정보를 교환하기 위함이다.
		원래의 정보처리 방식은 클라이언트(웹 브라우저) -> 서버 -> jsp였으나 ajax를 이용한다면
		클라이언트 -> 서버 -> ajax -> jsp -> 서버 -> 순환...후 클라이언트 이런식으로 돌아간다. 즉 ajax는 비동기식 통신 방식이다.
	 */

	/* redraw버튼 클릭시 진행. */
	$("#redraw").click(function(){
		var values = []; /* 리스트 값 받을 변수 */
		
		$.post("/ajaxjspdobak",
				function(cardList){
			if(cardList.connect=="success"){
				values = cardList.playerCardList;
				
				$.each(values, function(index, value){
					console.log(index + " : " + value.cardNum);
				});
				
				alert('성공');
			} else {
				alert('실패');
			}
		});
	}
	
	}
</script> 
</html>