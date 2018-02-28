<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>个人信息</title>
    <%@include file="../common/bscss.jsp"%>
</head>
<body>

<%@include file="../common/head.jsp"%>
<div class="row text-center">
    <div class="col-md-8 col-md-offset-2">
        <div class="text-center"><h4>个人信息</h4></div>
        <table class="table table-striped text-center table-bordered">
            <tr>
               <td>用户Id:</td>
               <td>${user.userId}</td>
           </tr>
            <tr>
                <td>用户名:</td>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td>${user.userEmail}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>${user.userSex}</td>
            </tr>
            <tr>
                <td>用户电话:</td>
                <td>${user.userPhone}</td>
            </tr>
            <tr>
                <td>注册时间:</td>
                <td>${user.createTime}</td>
            </tr>
            <tr>
                <td>用户类型:</td>
                <td>
                    <c:if test="${user.userType == 1}">
                        普通用户
                    </c:if>
                    <c:if test="${user.userType == 0}">
                        管理员
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>用户状态:</td>
                <td>
                    <c:if test="${user.userState == 0}">
                            正常
                    </c:if>
                    <c:if test="${user.userState == 1}">
                        冻结
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>个人积分:</td>
                <td>${user.credit}</td>
            </tr>
            <tr>
                <td>最后登录时间:</td>
                <td>${user.lastLoginTime}</td>
            </tr>
            <tr>
                <td>最后登录IP:</td>
                <td>${user.lastIp}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a class="btn btn-default"
                       href="/user/userUpdateInfo?username=${user.userName}">
                        修改个人信息
                    </a>
                    <a href="/main" class="btn btn-default">返回</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
</body>
</html>
