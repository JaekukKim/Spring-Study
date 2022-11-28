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
	<% 
		String firstHanded = (String)request.getAttribute("first"); 
		String secondHanded = (String)request.getAttribute("second");
		String totalHanded = (String)request.getAttribute("result");
	%>

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
					<div id="first"><%=firstHanded %></div>
				</td>
				<td>
					<div id="second"><%=secondHanded %></div>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<div id="result"><%=totalHanded %></div>
	</div>
</body>

<!-- js는 사용하지 않는다.
<script type="text/javascript">
	<%-- /* 다큐먼트 레디 해 줬으니 html 실행 후 js가 실행된다. */
	/* js 영역에 jsp 자바코드 태그가 들어가면 결과 출력일때는 =을 반드시 붙여줘야한다. */
	
	$(document).ready(function() {
		var firstHanded = "<%=request.getAttribute("first")%>"
		var secondHanded = "<%=request.getAttribute("second")%>"
		위 코드 두줄은 js 변수 안에 컨트롤러의 set된 값을 받아와서 바로 대입해주는 과정이다.
		일반 자바코드 선언시 <% %> 하면 되지만 특정 값을 출력할땐 반드시 <%= 값 %> 해주어야 한다.
		
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
	}); --%>
</script>
 -->
</html>