<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Ajax 공부</title>
</head>
<body>
	<div>
		<button onclick="sendingData()">컨트롤러에 데이터 출력</button>
	</div>
	<script>
		function sendingData() {
			$.ajax({
				url : "/ajaxreturn",
				type : "POST",
				data : {
					name : "123",
					age : "22",
					location : "서울"
				},
				/* datatype : "JSON", */
				success : function(data) {
					alert("contoller로 데이터 보내기 성공");
				},
				error : function() {
					alert("데이터 전송 실패");
				}
			});
		}
	</script>
</body>
</html>