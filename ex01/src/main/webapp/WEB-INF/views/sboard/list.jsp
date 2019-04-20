<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 리다이렉트 시 session을 이용하지 못하면, jsessionid가 url에 노출 됨 --%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>

<html>
	<table class="table table-bordered">
		<tr>
			<th style="width: 10px">BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th style="width: 40px">VIEWCNT</th>
		</tr>
	<c:forEach items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno}</td>
			<td><a href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVO.bno}'>${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
	</c:forEach>		
	</table>
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a href="${pageMaker.startPage - 1}">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : '' }" />>
					<a href="${idx}">${idx}</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="${pageMaker.endPage + 1}">&raquo;</a></li>
			</c:if>
			
			<form id="jobForm">
				<input type="hidden" name="page" />
				<input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}" />
			</form>
		</ul>
	</div>
</html>

<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	
	$(".pagination li a").on("click", function(event) {
		
		//디폴트 이벤트의 실행을 막는다.
		event.preventDefault();
		
		//클릭된 태그의 href속성 값을 불러온다.
		var targetPage = $(this).attr("href");
		
		//페이징과 관련된 정보를 form을 통해 서버에 전달한다.
		var jobForm = $("#jobForm");
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action", "/sboard/list").attr("method", "get");
		jobForm.submit();
		
	});
</script>

<%@ include file="../include/footer.jsp" %>