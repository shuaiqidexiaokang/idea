<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>主题管理</title>
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
        <div class="text-center"><h4>主题信息</h4></div>
        <table class="table table-striped text-center table-bordered">
            <thead>
            <tr>
                <td>主题ID</td>
                <td>主题名称</td>
                <td>发表用户</td>
                <td>浏览数量</td>
                <td>回复数量</td>
                <td>创建时间</td>
            </tr>
            </thead>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.postId}</td>
                    <td>${post.postTitle}</td>
                    <td>${post.postUserName}</td>
                    <td>${post.postViewCount}</td>
                    <td>${post.postReplyCount}</td>
                    <td>${post.postCreateTime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
