<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.6/handlebars.js"></script>
<html>
	
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly" />
		</div>
	</div> <!-- /.box-body -->
	
	<div class="box-footer">
		<ul class="mailbox-attachments clearfix uploadedList"></ul>
		<button type="submit" class="btn btn-warning modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">LIST ALL</button>
	</div>
	
	<div class="row">	<!-- 댓글 등록 부분 -->
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label for="newReplyWriter">Writer</label>
					<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
					<label for="newReplyText">ReplyText</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</div>
			</div>
			<!-- /.box-body -->
		</div>
	</div>
	
	<div class="row col-md-12">	<!-- 댓글 목록 및 페이징 부분 -->
		<!-- The time line -->
		<ul class="timeline">
			<li class="time-label" id="repliesDiv">
				<span class="bg-green">
					Replies List <small id="replycntSmall"> [ ${boardVO.replycnt} ] </small>
				</span>
			</li>
			<script id="template" type="text/x-handlebars-template">
			{{#each .}}
			<li class="replyLi" data-rno={{rno}}>
				<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">
					<span class="time">
						<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
					</span>
					<h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
					<div class="timeline-body">{{replytext}}</div>
					<div class="timeline-footer">
						<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">Modify</a>
					</div>
				</div>
			</li>
			{{/each}}
			</script>
		</ul>
		
		<div class="text-center">
			<ul id="pagination" class="pagination pagination-sm no-margin">
			</ul>
		</div>
	</div>
	
	<!-- Modal -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p><input type="text" id="replytext" class=form-control></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="popup back" style="display:none;"></div>
	<div id="popup_front" class="popup front" style="display:none;">
		<img id="popup_img">
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $('form[role="form"]');
		
		console.log(formObj);
		
		$(".goListBtn").on("click", function() {
			formObj.attr("action", "/sboard/list");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".removeBtn").on("click", function() {
			var replyCnt = $("#replycntSmall").html().replace(/[^0-9]/g, "");
			
			if(replyCnt > 0) {
				alert("댓글이 달린 게시물을 삭제 할 수 없습니다.");
				return;
			}
			
			var arr = [];
			$(".uploadedList li").each(function(index) {
				arr.push($(this).attr("data-src"));
			});
			
			if(arr.length > 0) {
				$.post("/deleteAllFiles", {files:arr}, function() {
					
				});
			}
			
			formObj.attr("action", "/sboard/removePage");
			formObj.submit();
		});
		
		$(".modifyBtn").on("click", function() {
			formObj.attr("action", "/sboard/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
	});
	</script>
	
	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno}" />
		<input type="hidden" name="page" value="${cri.page}" />
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}" />
		<input type="hidden" name="searchType" value="${cri.searchType}" />
		<input type="hidden" name="keyword" value="${cri.keyword}" />
	</form>
	
	<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src='{{fullName}}'>
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
		</div>
	</li>
	</script>
	
	<script src="/resources/js/upload.js"></script>
	<script>
	
	var bno = ${boardVO.bno};
	var templateAttach = Handlebars.compile($('#templateAttach').html());
	
	$.getJSON("/sboard/getAttach/" + bno, function(list) {
		$(list).each(function() {
			var fileInfo = getFileInfo(this);
			var html = templateAttach(fileInfo);
			$(".uploadedList").append(html);
		});
	});
	
	$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event) {
		var fileLink = $(this).attr("href");
		
		if(checkImageType(fileLink)) {
			event.preventDefault();
			
			var imgTag = $("#popup_img");
			imgTag.attr("src", fileLink);
			
			console.log(imgTag.attr("src"));
			
			$(".popup").show("slow");
			imgTag.addClass("show");
		}
	});
	
	$("#popup_img").on("click", function() {
		$(".popup").hide("slow");
	});
	
	var replyPage = 1;
	
	var printData = function(replyArr, target, templateObject) {
		
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
		
	}
	
	var printPaging = function(pageMaker, target) {
		
		var str = "";
		
		if(pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
		}
		
		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active':'';
			str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
		}
		
		if(pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>"
		}
		
		target.html(str);
	}
	
	function getPage(pageInfo) {
		
		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#repliesDiv"), $('#template'));	//댓글 본문 rendering
			printPaging(data.pageMaker, $(".pagination"));	//댓글 페이징 부분 rendering
			
			$("#modifyModal").modal('hide');
			$("#replycntSmall").html("[ " + data.pageMaker.totalCount +" ]");
		});
	}
	
	//Handlebars가 제공하지 않는 helper를 사용자가 직접 추가하여 사용 가능
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	
	$("#repliesDiv").on("click", function() {
		if($(".timeline li").size() > 1) {
			return;
		}
		getPage("/replies/" + bno + "/1");
	});
	
	$(".pagination").on("click", "li a", function(event) {
		event.preventDefault();
		replyPage = $(this).attr("href");
		getPage("/replies/" + bno + "/" + replyPage);
	});
	
	$("#replyAddBtn").on("click", function() {
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		
		$.ajax({
			type: 'post',
			url: '/replies/',
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST" },
			dataType: 'text',
			data: JSON.stringify({bno: bno, replyer: replyer, replytext: replytext}),
			success: function(result) {
				console.log("result: " + result);
				if(result == 'SUCCESS') {
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					replyerObj.val("");
					replytextObj.val("");
				}
			}
		});
	});
	
	$(".timeline").on("click", ".replyLi", function(event) {
		var reply = $(this);
		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
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
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
	
	$("#replyDelBtn").on("click", function() {
		
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			type: "delete",
			url: "/replies/" + rno,
			headers: {
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType: "text",
			success: function(result) {
				console.log("result: " + result);
				if(result == "SUCCESS") {
					alert("삭제 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
	
	</script>
	
	<style>
	.popup {
		position: absolute;
		top: 0px;
	}
	.back {
		background-color: gray;
		opacity: 0.5;
		width: 100%;
		height: 300%;
		overflow: hidden;
		z-index: 1100;
	}
	.front {
		z-index: 1101;
		opacity: 1;
		boarder: 1px;
		margin: auto;
	}
	.show {
		position: relative;
		max-width: 1200px;
		max-height: 800px;
		overflow: auto;
	}
	</style>
	
</html>

<%@ include file="../include/footer.jsp" %>