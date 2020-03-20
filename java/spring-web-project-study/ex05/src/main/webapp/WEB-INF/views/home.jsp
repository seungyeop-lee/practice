<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="include/header.jsp" %>

	<!-- Main Content -->
	<section class="content">
		<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-boarder">
					<h3 class="box-title">HOME PAGE</h3>
					<h3 class="box-content">${result}</h3>
				</div>
			</div>
		</div> <!-- /.col (left) -->
		</div> <!-- /.row -->
	</section> <!-- /.content -->

<%@ include file="include/footer.jsp" %>