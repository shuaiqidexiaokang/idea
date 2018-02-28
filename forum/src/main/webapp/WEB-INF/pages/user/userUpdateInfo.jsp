<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>修改个人信息</title>
    <%@include file="../common/bscss.jsp" %>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
</head>
<body>

<%@include file="../common/head.jsp" %>
<div class="row text-center">
    <div class="col-md-6 col-md-offset-3">
        <form class="form-horizontal" action="/user/updateUserInfo" method="POST">
            <h4>修改个人信息</h4>
            <div class="form-group">
                <label class="col-sm-2 control-label">用户Id:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.userId}" name="userId" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">用户名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.userName}" name="userName" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">邮箱:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" value="${user.userEmail}" name="userEmail">
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" name="${user.userSex}">
                <label class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-10">
                    <select name="userSex" class="form-control selectpicker" title="${user.userSex}">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">电话:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.userPhone}" name="userPhone">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">注册时间:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.createTime}" name="createTime" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">用户类型:</label>
                <div class="col-sm-10">
                    <c:if test="${user.userType == 0}">
                        <input type="text" class="form-control" value="普通用户" readonly>
                    </c:if>
                    <c:if test="${user.userType == 1}">
                        <input type="text" class="form-control" value="管理员" readonly>
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">用户状态:</label>
                <div class="col-sm-10">
                    <c:if test="${user.userState == 0}">
                        <input type="text" class="form-control" value="正常" readonly>
                    </c:if>
                    <c:if test="${user.userState == 1}">
                        <input type="text" class="form-control" value="冻结" readonly>
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">个人积分:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.credit}" name="credit" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">最后登录时间:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.lastLoginTime}" name="lastLoginTime" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">最后登录IP:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" value="${user.lastIp}" name="lastIp" readonly>
                </div>
            </div>
            <div class="form-group col-sm-12">
                <button class="btn btn-primary submit" type="submit">修改</button>&ensp;&ensp;
                <a class="btn btn-primary" href="/index">返回</a>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
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
