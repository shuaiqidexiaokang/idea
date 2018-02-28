<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3 col-md-offset-1">
    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="输入想搜索的内容...">
            <input type="hidden" name="pageNo" value="${page.pageNo}">
        </div>
    </form>
    <p>热门文章</p>
    <c:forEach items="${hotBlog}" var="article">
        <a href="${pageContext.request.contextPath}/article/${article.articleId}/details"><p>${article.title}(${article.readNumber}+阅读)</p></a>
    </c:forEach>
    <p>近期文章</p>
    <c:forEach items="${newBlog}" var="article">
        <a href="${pageContext.request.contextPath}/article/${article.articleId}/details"><p>${article.title}(<fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>)</p></a>
    </c:forEach>
    <p>分类目录</p>
    <c:forEach items="${types}" var="type">
        <a href="${pageContext.request.contextPath}/article/index?typeId=${type.typeId}"><p>${type.typeName}(${type.number})</p></a>
    </c:forEach>
    <p>日期归档</p>
    <c:forEach items="${dates}" var="date">
        <a href="${pageContext.request.contextPath}/article/index?createTime=${date.createTime}"><p>${date.createTime}(${date.count})</p></a>
    </c:forEach>
    <p>友情链接</p>
</div>