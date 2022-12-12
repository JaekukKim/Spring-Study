<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 값 테스트.</title>
</head>
<body>
	이 메세지가 보인다면 정상적으로 쿠키가 생성된겁니다! 데브툴즈에서 확인해보세요!
	<br><br>
	<div>1번 쿠키 이름 : ${cookie1.getName() }</div>
	<div>1번 쿠키 값 : ${cookie1.getValue() }</div>
	<hr>
	<div>2번 쿠키 이름 : ${cookie2.getName() }</div>
	<div>2번 쿠키 값 : ${cookie2.getValue() }</div>
	<br>
	<div>올 쿠키 : 는 출력이 안됩니다...</div>
</body>
</html>