<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>添加版块</title>
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
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-md-6 col-md-push-3">
        <div class="text-center"><h4>添加版块</h4></div>
        <form class="form-horizontal" action="/admin/addBoard" method="post">
            <div class="form-group">
                <label for="boardName" class="col-sm-2 control-label">版块名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="boardName" placeholder="版块名" name="boardName">
                </div>
            </div>
            <div class="form-group">
                <label for="boardDesc" class="col-sm-2 control-label">版块描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="boardDesc" placeholder="版块描述" name="boardDesc">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input class="btn btn-default" type="submit" value="添加">
                    <a class="btn btn-default" href="/admin/manageCenter">返回</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
