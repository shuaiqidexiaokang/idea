<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>板块管理</title>
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
                <li><a href="/addBoard">添加版块</a></li>
                <li><a href="/admin/manageCenter">返回</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-md-8 col-md-push-2">
        <div class="text-center"><h4>板块管理</h4></div>
        <table class="table table-striped text-center table-bordered">
            <thead>
            <tr>
                <td>版块ID</td>
                <td>版块名称</td>
                <td>版块描述</td>
                <td>版块总帖数</td>
                <td>操作</td>
            </tr>
            </thead>
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td>${board.boardId}</td>
                    <td>${board.boardName}</td>
                    <td>${board.boardDesc}</td>
                    <td>${board.boardPostNum}</td>
                    <td>
                        <a href="/updateBoardPage?boardId=${board.boardId}">修改</a>&ensp;
                        <a href="/admin/deleteBoard?boardId=${board.boardId}">删除</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
