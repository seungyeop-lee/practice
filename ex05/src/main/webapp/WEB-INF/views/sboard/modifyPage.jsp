<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<html>
	<%-- action을 생략 할 경우, searchType과 keyword가 두번 전송되는 문제가 발생 --%>
	<form role="form" action="modifyPage" method="post">
	
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<input type="hidden" name="searchType" value="${cri.searchType}" />
		<input type="hidden" name="keyword" value="${cri.keyword}" />
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">BNO</label>
				<input type="text" name="bno" class="form-control" value="${boardVO.bno}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label>
				<input type="text" name="title" class="form-control" value="${boardVO.title}" />
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label>
				<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">File DROP Here</label>
				<div class="fileDrop"></div>
			</div>
		</div> <!-- /.box-body -->
	</form>
	
	<div class="box-footer">
		<div>
			<hr>
		</div>
		
		<ul class="mailbox-attachments clearfix uploadedList">
		</ul>
		
		<button type="button" class="btn btn-primary">SAVE</button>
		<button type="button" class="btn btn-warning">CANCEL</button>
	</div>
	
	<style>
	.fileDrop {
		width: 80%;
		height: 100px;
		border: 1px dotted gray;
		background-color: lightslatedgrey;
		margin: auto;
	}
	</style>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.6/handlebars.js"></script>
	<script id="template" type="text/x-handlebars-template">
	<li>
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn">
				<i class="fa fa-fw fa-remove"></i>
			</a>
		</div>
	</li>
	</script>
	
	<script src="/resources/js/upload.js"></script>
	<script>
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function(event) {
		event.preventDefault();
		
		var originalEvent = event.originalEvent;
		var files = originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url: "/uploadAjax",
			data: formData,
			dataType: "text",
			processData: false,
			contentType: false,
			type: "POST",
			success: function(data) {
				var fileInfo = getFileInfo(data);
				var html = template(fileInfo);
				$(".uploadedList").append(html);
			}
		});
	});
	
	$('form[role="form"]').submit(function(event) {
		event.preventDefault();
		
		var that = $(this);
		var str = "";
		
		$(".uploadedList .delbtn").each(function(index) {
			str += "<input type='hidden' name='files[" + index + "]' value='" + $(this).attr("href") + "'> ";
		});
		
		that.append(str);
		that.get(0).submit();
	});
	
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $('form[role="form"]');
		
		console.log(formObj);
		
		$('.btn-primary').on('click', function() {
			formObj.submit();
		});
		
		$('.btn-warning').on('click', function() {
			self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}";
		});
	});
	</script>
</html>

<%@ include file="../include/footer.jsp" %>