<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>Excited</title>
    <%@include file="../common/bscss.jsp" %>
    <style>
        .reply {
            width: 70px;
            height: 64px;
            /* position: absolute; */
            /* right: -80px; */
            /* top: 0; */
            /* padding: 4px 15px; */
            /* font-size: 14px; */
            /* color: #fff; */
            border-radius: 4px;
            text-align: center;
            min-width: 60px;
            vertical-align: top;
            cursor: pointer;
            background-color: #00a1d6;
            border: 1px solid #00a1d6;
            transition: .1s;
            user-select: none;
            outline: none;
        }
        .info{
            color: #99a2aa;
            line-height: 26px;
            font-size: 12px;
        }
        .user{
            font-size: 12px;
            font-weight: 700;
            line-height: 18px;
            padding-bottom: 4px;
            display: block;
            word-wrap: break-word;
        }
    </style>
</head>
<body>
<%@include file="../common/head.jsp" %>
<div class="row">
    <div class="col-md-6 col-md-push-3">
        <div class="panel panel-default">
            <div class="text-center">
                <h2>${post.postTitle}</h2>
                <div>
                    发表时间：${post.postCreateTime}&nbsp;&nbsp;&nbsp;
                    作者：${post.postUserName}&nbsp;&nbsp;&nbsp;
                    浏览次数：${post.postViewCount}
                </div>
            </div>
            <hr>
            <div class="panel-body">${post.postContent}</div>
            <div class="text-center">
                <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>${post.postGoodCount}&nbsp;&nbsp;&nbsp;
                <span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>${post.postBadCount}
            </div>
        </div>
    </div>
</div>
<div class="col-md-6 col-md-push-3">
    <c:choose>
        <c:when test="${username !=null}">
            <hr>
            评论
            <div>
                <textarea name="msg" id="" cols="77" rows="3" placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"></textarea>
                <a class="btn btn-primary reply"
                   href="/reply/addReply?replyPostId=${post.postId}&replyUserName=${username}">发表评论</a>
            </div>
        </c:when>
    </c:choose>
    <c:if test="${replies !=null}">
        <c:forEach items="${replies}" var="reply">
            <hr>
            <div class="panel panel-default">
                <div class="user">${reply.replyUserName}</div>
                <p>${reply.replyContent}</p>
                <div class="info">
                    <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>${reply.replyGoodCount}&nbsp;&nbsp;&nbsp;
                    <span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>${reply.replyBadCount}&nbsp;&nbsp;&nbsp;
                    ${reply.replyCreateTime}
                </div>
            </div>
        </c:forEach>
    </c:if>
    <hr>
</div>
<%@include file="../common/bsjq.jsp" %>
</body>
</html>
