<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%@include file="../common/bscss.jsp"%>
</head>
<body>

<nav class="navbar navbar-default navbar-static-top" id="blog-head">
    <div class="container-fluid" id="blog-container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">Excited</a>
        </div>
    </div><!-- /.container-fluid -->
</nav>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form class="form-horizontal" action="/user/userLogin" method="post">
            <div class="form-group">
                <label for="inputUserName" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserName" placeholder="用户名" name="userName">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" placeholder="密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input class="btn btn-default" type="submit" value="登录">
                    <a class="btn btn-default" href="/userRegister">注册</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
<script type="text/javascript">
    $(function(){
        $("#userRegister").click(function(){
            alert("aa");
            window.location("/userRegister");
        });
    });
</script>
</body>
</html>
