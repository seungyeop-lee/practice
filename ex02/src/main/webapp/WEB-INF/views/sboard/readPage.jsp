<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

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
				<span class="bg-green">Replies List</span>
			</li>
		</ul>
		
		<div class="text-center">
			<ul id="pagination" class="pagination pagination-sm no-margin">
			</ul>
		</div>
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
	
</html>

<%@ include file="../include/footer.jsp" %>