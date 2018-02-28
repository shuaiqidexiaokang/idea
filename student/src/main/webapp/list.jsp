<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="/common/bscss.jsp" %>
    <title>学生列表</title>
</head>
<body>
<div class="container">
    <div class="row text-center">
        <div class="panel panel-default">
            <div class="panel-heading">学生信息管理</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3">id</div>
                    <div class="col-md-3">姓名</div>
                    <div class="col-md-3">年龄</div>
                    <div class="col-md-3">操作</div>
                </div>
                <div class="row" id="show">
                    <a href=""></a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/common/bsjq.jsp" %>
<script type="text/javascript">
    $(function () {
        onload();
    })
    function onload(){
        $.get("/student/list", {}, function (date) {
            var show = $('#show');
            var str = "";
            for (var student in date) {
                str += ' <div class="col-md-3">' + date[student].id + '</div>' +
                    '<div class="col-md-3">' + date[student].name + '</div>' +
                    '<div class="col-md-3">' + date[student].age + '</div>' +
                    '<div class="col-md-3">修改 &ensp;删除</div>';
            }
            show.html(str);
        });
    }
</script>
</body>
</html>