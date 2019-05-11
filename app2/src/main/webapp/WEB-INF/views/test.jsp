<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${msg}</h1>

	<%-- 스프링 부트는 기본적으로 UTF-8을 지원하므로 한글 전송에 문제가 없다. --%>
	<form method="post">
		<p> USER NAME: <input type="text" name="username"> </p>
		<p> ADDRESS: <input type="text" name="address"> </p>
		<p> <input type="submit"> </p>
	</form>

</body>
</html>