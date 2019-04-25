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
	
	<div>
		<div>
			REPLYER <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			REPLY TEXT <input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
	</div>
	
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
		
		$("#replyAddBtn").on("click", function() {
			
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			
			$.ajax({	//$.post를 사용 할 경우 서버에 보내는 데이터 형식이 form을 사용하였을 때와 동일하여 오작동
				type: "post",
				url: "/replies",
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType: "text",
				data: JSON.stringify({
					bno: bno,
					replyer: replyer,
					replytext: replytext
				}),
				success: function(result) {
					if(result == "SUCCESS") {
						alert("등록 되었습니다.");
						getAllList();
					}
				}
			});
		});
	</script>
	
</body>
</html>