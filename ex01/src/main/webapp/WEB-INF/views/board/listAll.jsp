<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 리다이렉트 시 session을 이용하지 못하면, jsessionid가 url에 노출 됨 --%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
	</table>
</html>

<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@ include file="../include/footer.jsp" %>