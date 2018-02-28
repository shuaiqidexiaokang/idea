<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>论坛管理</title>
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
        <table class="table table-striped table-bordered text-center">
            <tbody>
                <tr>
                    <th colspan="2"><h4 class="text-center">论坛管理</h4></th>
                </tr>
                <tr>
                    <td>用户管理</td>
                    <td><a href="/admin/manageUser">查看</a></td>
                </tr>
                <tr>
                    <td>板块管理</td>
                    <td><a href="/admin/manageBoard">查看</a></td>
                </tr>
                <tr>
                    <td>主题管理</td>
                    <td><a href="/admin/managePost">查看</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
