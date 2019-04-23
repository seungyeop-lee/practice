<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Ajax Test Page</h2>
	<ul id="replies">
	</ul>
	
	<script type="text/javascript" src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	
	<script type="text/javascript">
		var bno = 5;
		
		//전체 댓글 목록 갱신 함수
		function getAllList() {
			$.getJSON("/replies/all/" + bno, function(data) {
				
				var str = "";
				console.log(data.length);
				
				$(data).each(function() {
					//'data-'로 시작되는 속성은 이름, 개수 상관없이 태그 내에서 자유롭게 사용가능 한 속성
					//id나 name속성을 대신해서 사용하기가 용이
					str += "<li data-rno='" + this.rno + "' class='replyLi'>"
						+ this.rno + " : " + this.replytext
						+ "</li>";
				});
				
				$("#replies").html(str);
				
			});
		}
	</script>
	
</body>
</html>