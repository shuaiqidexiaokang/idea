<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excited</title>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="../resources/assets/css/reset.css">
    <link rel="stylesheet" href="../resources/assets/css/supersized.css">
    <link rel="stylesheet" href="../resources/assets/css/style.css">
</head>
<body>
<div class="page-container">
    <h1>Login</h1>
    <form action="/user/userLogin" method="post">
        <input type="text" name="userName" class="username" placeholder="Username">
        <input type="password" name="password" class="password" placeholder="Password">
        <button type="submit">登录</button>
        <button type="submit">注册</button>
        <div class="error"><span>+</span></div>
    </form>
</div>
<script src="../resources/assets/js/jquery-1.8.2.min.js"></script>
<script src="../resources/assets/js/supersized.3.2.7.min.js"></script>
<script src="../resources/assets/js/supersized-init.js"></script>
<script src="../resources/assets/js/scripts.js"></script>
</body>
</html>
