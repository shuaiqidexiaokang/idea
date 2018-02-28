<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>用户注册</title>
    <%@include file="../common/bscss.jsp"%>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" id="blog-head">
    <div class="container-fluid" id="blog-container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">Excited</a>
        </div>
    </div>
</nav>
<div class="row text-center">
    <div class="panel panel-default col-md-6 col-md-push-3">
        <h2>欢迎注册</h2>
        <form class="form-horizontal" action="/user/register" method="post">
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="text" class="form-control" placeholder="用户名" name="userName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="password" class="form-control" placeholder="密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="email" class="form-control" placeholder="邮箱" name="userEmail">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <select name="userSex" class="form-control">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div><%--
            <div class="form-group">
                男性<input type="radio" value="男" name="userSex" checked>
                女性<input type="radio" value="女" name="userSex">
            </div>--%>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="text" class="form-control" placeholder="电话" name="userPhone">
                </div>
            </div>
            <div class="form-group">
                    <button type="submit" class="btn btn-default">注册</button>
                    <a class="btn btn-default" href="/index">返回</a>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>

