<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <a href="emps">List All Employees</a><br><br>
    <a href="testJson" id="testJson">testJson</a><br><br>
    <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
        File:<input type="file" name="file"/><br>
        Desc:<input type="text" name="desc"/><br>
        <input type="submit" value="Submit"/><br>
    </form>
    <a href="testResponseEntity">testResponseEntity</a><br><br>


    <form action="testFileUpload" method="post" enctype="multipart/form-data">
        File:<input type="file" name="file"/><br>
        Desc:<input type="text" name="desc"/><br>
        <input type="submit" value="Submit"/><br>
    </form>

    <a href="testExceptionHandlerExceptionResolver?i=10">testExceptionHandlerExceptionResolver</a><br><br>
    <a href="testResponseStatusExceptionResolver?i=10">testResponseStatusExceptionResolver</a><br><br>
    <a href="testDefaultHandlerExceptionResolver">testDefaultHandlerExceptionResolver</a><br><br>
    <a href="testSimpleMappingExceptionResolver?i=9">testSimpleMappingExceptionResolver</a><br><br>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resoucrce/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#testJson").click(function () {
            var url = this.href;
            var args = {};
            var href = $(this).attr("href");
            $.post(url,args,function (data) {
                for(var i = 0;i<data.length; i++){
                    var id = data[i].id;
                    var lastName = data[i].lastName;
                    alert(id + ":" + lastName);
                }
            })
            return false;
        });
    })
</script>
</html>
