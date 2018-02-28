<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="common/bscss.jsp"%>
    <title>帅气小康的博客</title>
</head>
<body>
<div class="container">
    <!-- head start-->
    <%@include file="common/head.jsp"%>
    <!-- head end-->
<%--ELECT a.article_id, a.title, a.type_id, a.keyword, a.summary, a.context,
a.read_number, a.create_Time, t.type_id "type.type_id", t.type_name "type.type_name",
t.number "type.number" FROM article a INNER JOIN type t ON
a.type_id = t.type_id WHERE t.type_id = ? OR
DATE_FORMAT(a.create_time, '%Y年%m月') = '2018年02月' ORDER BY a.create_Time DESC LIMIT ?, ?
--%>
    <!-- context start -->
    <!-- context left start -->
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${articles}" var="article">
                <a href="${pageContext.request.contextPath}/article/${article.articleId}/details">${article.title}</a>
                <div style="margin-top: 10px;">
                    <p>类别：${article.type.typeName}&emsp;阅读:${article.readNumber}&emsp;发布时间:
                        <fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                </div>
                <p>${article.context}</p>
                <hr>
            </c:forEach>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${page.pageNo !=page.beginIndex}">
                        <li>
                            <a href="${pageContext.request.contextPath}/article/index?pageNo=${page.pageNo-1}&typeId=${typeId}&createTime=${createTime}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="${page.beginIndex}" end="${page.endIndex}">
                        <li><a href="${pageContext.request.contextPath}/article/index?pageNo=${i}&typeId=${typeId}&createTime=${createTime}">${i}</a></li>
                    </c:forEach>
                    <c:if test="${page.pageNo !=page.endIndex}">
                        <li>
                            <a href="${pageContext.request.contextPath}/article/index?pageNo=${page.pageNo+1}&typeId=${typeId}&createTime=${createTime}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <!-- context left end -->

        <!-- context right start -->
        <%@include file="common/right.jsp"%>
        <!-- context right end -->
    </div>
    <!-- context end -->

    <!-- foot start -->
    <%@include file="common/foot.jsp"%>
    <!-- foot end -->
</div>

<%@include file="common/bsjq.jsp"%>
</body>
</html>