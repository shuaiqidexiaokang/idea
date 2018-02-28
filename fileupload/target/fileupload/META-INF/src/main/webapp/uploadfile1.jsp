<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadServlet1" method="post" enctype="multipart/form-data">
    File: <input type="file" name="file"/>
    <br>
    <br>
    Desc: <input type="text" name="desc"/>
    <br>
    <br>
    <input type="checkbox" name="interesting" value="Reading"/>Reading
    <input type="checkbox" name="interesting" value="Party"/>Party
    <input type="checkbox" name="interesting" value="Sports"/>Sports
    <input type="checkbox" name="interesting" value="Shopping"/>Shopping
    <br>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
