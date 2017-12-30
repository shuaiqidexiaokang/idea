<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Success Page<br><br>
    time:${requestScope.time}<br><br>
    names:${requestScope.names}<br><br>
    request user:${requestScope.user}<br>
    sesstion user:${sessionScope.user}<br>
    request school:${requestScope.school}<br>
    sesstion school:${sessionScope.school}<br>
</body>
</html>
