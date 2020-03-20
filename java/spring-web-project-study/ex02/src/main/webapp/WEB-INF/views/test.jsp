<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>
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
	<ul class="pagination">
	</ul>
	
	<div id="modDiv" style="display: none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">DELETE</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
	
	<script type="text/javascript" src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	
	<script type="text/javascript">
		var bno = 5;
		var replyPage = 1;
		
		getPageList(1);
		
		//전체 댓글 + 페이징 갱신 함수
		function getPageList(page) {
			$.getJSON("/replies/" + bno + "/" + page, function(data) {
				
				console.log(data.list.length);
				var str = "";
				
				$(data.list).each(function() {
					str += "<li data-rno='" + this.rno + "' class='replyLi'>"
						+ this.rno + " : " + this.replytext
						+ "<button>MOD</button></li>";
				});
				
				$("#replies").html(str);
				
				printPaging(data.pageMaker);
				
			});
		}
		
		//댓글의 페이징 생성 함수
		function printPaging(pageMaker) {
			
			var str = "";
			
			if(pageMaker.prev) {
				str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
			}
			
			for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
				var strClass = pageMaker.cri.page == i ? 'class=active':'';	//현재 페이지에 해당하면 active 클래스를 부여
				str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
			}
			
			if(pageMaker.next) {
				str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>"
			}
			
			$('.pagination').html(str);
		}
		
		$(".pagination").on("click", "li a", function(event) {
			
			event.preventDefault();	//<a>태그의 디폴트 이벤트를 억제
			
			replyPage = $(this).attr("href");
			
			getPageList(replyPage);
		});
		
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
						+ "<button>MOD</button></li>";
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
						getPageList(replyPage);
					}
				}
			});
		});
		
		//ul태그 내부에서 click이벤트가 발생하였을 때
		//이벤트 발생장소가 정확히 replyLi 클래스 내부에 button태그일 경우 handler가 실행 됨 
		$("#replies").on("click", ".replyLi button", function() {
			
			var reply = $(this).parent();	//버튼의 부모. 즉 li태그
			
			var rno = reply.attr("data-rno");
			var replytext = reply.text();
			
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			$("#modDiv").show("slow");	//display: none이었던 부분이 애니메이션과 함께 표시 됨
			
		});
		
		$("#replyDelBtn").on("click", function() {
			
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type: "delete",
				url: "/replies/" + rno,
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"DELETE"	//옛날 브라우저 대응 (GET과 POST방식만 있으므로 헤더로 메소드를 알려줌)
				},
				dataType: "text",
				success: function(result) {
					console.log("result: " + result);
					if(result == "SUCCESS") {
						alert("삭제 되었습니다.");
						$("#modDiv").hide("slow");	//서서히 사라져서 disply: none 상태가 됨
						getPageList(replyPage);
					}
				}
			});
		});
		
		$("#replyModBtn").on("click", function() {
			
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type: "put",
				url: "/replies/" + rno,
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"PUT"
				},
				dataType: "text",
				data: JSON.stringify({
					replytext: replytext
				}),
				success: function(result) {
					console.log("result: " + result);
					if(result == "SUCCESS") {
						alert("수정 되었습니다.");
						$("#modDiv").hide("slow");
						getPageList(replyPage);
					}
				}
			});
		});
	</script>
	
</body>
</html>