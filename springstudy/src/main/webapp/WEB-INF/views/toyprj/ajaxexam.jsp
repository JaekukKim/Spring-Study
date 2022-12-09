<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>ajax</title>
</head>

<body>
	<input type="button" onclick="getCard()" value="카드받기">
	<br>
	<p id="result"></p>
</body>

<script>
function getCard(){
	
	$.ajax({
		url : "/cardgame", /* [2] 카드를 뿌려주는 url이 담겨있는 @requestmapping value??? 값??? 그걸 여기다 넣어야함. */
		type : "POST",
		/* [1]위에 있는 url type data는 서버에 직접적으로 갔다오는 부분이다. */
		data : {
			name : "이름",
			age : "20",
			gender : "man"
		},
		/* [2]그리고 위에 있는부분들이 서버에 갔다오는게 "성공" 한다면 => success // "실패" 한다면 => error */
		success : function (data) {
			//[] = 배열
			//{} = JSON, MAP형 
			//[{"deckNum":null, "cardNum":"5"}, {"deckNum":null, "cardNum":"4"}, {"deckNum":null, "cardNum":"5"}]
			//[1, 2, 3]
			// alert("test");
			
			$(data).each(function () {
				alert(this.pattern + " " + this.number);
			});
			
			/* 여기다가는 보여주는 함수를 생성하면 된다.
			그럼 위에있는 value="카드받기"를 누르면
			다시 카드를 찍어낸 서버(메소드)로 가서
			새로운 카드 받은다음 새로고침 없이 다시 보여줌. */
		},
		
		error : function() {
			alert("카드찢어짐");
		}
		
	});
}	
</script>
</html>