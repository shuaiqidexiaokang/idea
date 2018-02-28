<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-static-top" id="blog-head">
    <div class="container-fluid" id="blog-container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">Excited</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${username !=null}">
                        <li><a href="/user/listUserInfo?username=${username}">${username}</a></li>
                        <c:if test="${username == 'admin'}">
                            <li><a href="/admin/manageCenter">登入管理后台</a></li>
                        </c:if>
                        <li><a href="/user/loginOut">注销</a></li>
                    </c:when>
                    <c:when test="${username == null}">
                        <li><a href="/userLogin">登录</a></li>
                        <li><a href="/userRegister">注册</a></li>
                    </c:when>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>