<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>论坛版块</title>
    <%@include file="common/bscss.jsp"%>
</head>
<body>
    <%@include file="common/head.jsp"%>
    <div class="row">
        <c:forEach items="${boards}" var="board">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/board/listPosts-${board.boardId}">${board.boardName}</a></div>
                <ul class="list-group">
                    <li class="list-group-item">${board.boardDesc}</li>
                    <li class="list-group-item">${board.boardPostNum}</li>
                </ul>
            </div>
        </div>
        </c:forEach>
    </div>

    <%@include file="common/bsjq.jsp"%>
</body>
</html>
