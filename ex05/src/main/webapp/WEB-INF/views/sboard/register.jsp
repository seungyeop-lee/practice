<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

	<form role="form" method="post" id="registerForm">
		<div class="box-body">
			<div class="form-group">
				<label for="exmapleInputEmail1">Title</label>
				<input type="text" name="title" class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3" placeholder="Enter ..."></textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label>
				<input type="text" name="writer" class="form-control" value="${login.uid}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">File DROP Here</label>
				<div class="fileDrop"></div>
			</div>
		</div> <!-- /.box-body -->
		
		<div class="box-footer">
			<div>
				<hr>
			</div>
			
			<ul class="mailbox-attachments clearfix uploadedList">
			</ul>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	
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
	
	$("#registerForm").submit(function(event) {
		event.preventDefault();
		
		var that = $(this);
		var str = "";
		
		$(".uploadedList .delbtn").each(function(index) {
			str += "<input type='hidden' name='files[" + index + "]' value='" + $(this).attr("href") + "'> ";
		});
		
		that.append(str);
		that.get(0).submit();	//jquery에 get(0)메소드는 순수한 DOM객체를 반환
	});
	
	</script>

<%@ include file="../include/footer.jsp" %>