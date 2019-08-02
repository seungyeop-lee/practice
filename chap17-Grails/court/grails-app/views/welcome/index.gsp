%{-- /welcome/index로 접근가능 (index는 생략가능) --}%
<!DOCTYPE html>
<html>
<head>
    <title><g:message code="welcome.title"/></title>
</head>

<body>
    <h2><g:message code="welcome.message"/></h2>
    %{-- ${}을 사용하여 컨트롤러에서 넘겨준 데이터에 접근가능 --}%
    Today is <g:formatDate format="yyyy-MM-dd" date="${today}"/>
</body>
</html>