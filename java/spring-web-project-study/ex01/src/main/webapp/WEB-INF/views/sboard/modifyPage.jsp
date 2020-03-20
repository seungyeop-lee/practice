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
		</div> <!-- /.box-body -->
	</form>
	
	<div class="box-footer">
		<button type="button" class="btn btn-primary">SAVE</button>
		<button type="button" class="btn btn-warning">CANCEL</button>
	</div>
	
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