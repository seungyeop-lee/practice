<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
<style>
iframe {
	width: 0px;
	height: 0px;
	border: 0px;
}
</style>
</head>
<body>
	<!-- 파일 전송 후 target속성값을 name속성값으로 가진 iframe에 결과를 표시 -->
	<form id="form1" action="uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">
		<input type="file" name="file">
		<input type="submit">
	</form>
	
	<iframe name="zeroFrame"></iframe>
	
	<script>
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
		}
	</script>
</body>
</html>