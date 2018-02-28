<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>Excited</title>
    <%@include file="../common/bscss.jsp"%>
</head>
<body>
<%@include file="../common/head.jsp"%>
<div class="row">
    <c:forEach items="${board.posts}" var="post">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/post/postContent-${post.postId}">${post.postTitle}</a></div>
                <ul class="list-group">
                    <li class="list-group-item">${post.postUserName}</li>
                    <li class="list-group-item">${post.postContent}</li>
                </ul>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
