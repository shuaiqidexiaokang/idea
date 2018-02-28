<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>修改版块</title>
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
        <div class="text-center"><h4>修改版块</h4></div>
        <form class="form-horizontal" action="/admin/updateBoard" method="post">
            <input type="hidden" class="form-control" name="boardId" value="${board.boardId}">
            <div class="form-group">
                <label class="col-sm-2 control-label">版块名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="boardName" value="${board.boardName}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">版块描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="boardDesc" value="${board.boardDesc}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">板块帖子数量</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="boardPostNum" value="${board.boardPostNum}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input class="btn btn-default submit" type="submit" value="修改">
                    <a class="btn btn-default" href="/admin/manageCenter">返回</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
<script type="text/javascript">
    $(function(){
        $('.submit').click(function(){
            var result = confirm("请确认修改！");
            return result;
        })
    })
</script>
</body>
</html>
