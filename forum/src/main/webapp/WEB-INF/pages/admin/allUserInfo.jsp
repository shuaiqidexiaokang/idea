<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>用户管理</title>
    <%@include file="../common/bscss.jsp"%>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" id="blog-head">
    <div class="container-fluid" id="blog-container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">Excited</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/user/listUserInfo?username=${username}">${username}</a></li>
                <li><a href="/user/loginOut">注销</a></li>
                <li><a href="/admin/manageCenter">返回</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-md-8 col-md-push-2">
        <div class="text-center"><h4>用户管理</h4></div>
        <table class="table table-striped text-center table-bordered">
            <thead>
                <tr>
                    <td>用户Id</td>
                    <td>用户名</td>
                    <td>邮箱</td>
                    <td>性别</td>
                    <td>手机</td>
                    <td>最后登录时间</td>
                    <td>最后登录IP</td>
                </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.userEmail}</td>
                    <td>${user.userSex}</td>
                    <td>${user.userPhone}</td>
                    <td>${user.lastLoginTime}</td>
                    <td>${user.lastIp}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
