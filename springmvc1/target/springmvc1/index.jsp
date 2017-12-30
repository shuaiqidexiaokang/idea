<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <body>
        <a href="hello">HelloWorld</a><br><br>

        <a href="RequestMappingTest/testRequestMapping">testRequestMapping</a><br><br>

        <a href="RequestMappingTest/testMethod">testMethod</a><br><br>

        <form action="RequestMappingTest/testMethod" method="post">
            <input type="submit" value="SUBMIT">
        </form><br><br>

        <a href="RequestMappingTest/testParamsAndHeaders?username=haha&password=20">testParamsAndHeaders</a><br><br>

        <a href="RequestMappingTest/testAntPath/asd/abc">testAntPath</a><br><br>

        <a href="RequestMappingTest/testPathVariable/2">testPathVariable</a><br><br>

        <a href="RequestMappingTest/testRestGet/1">testRestGet</a><br><br>

        <form action="RequestMappingTest/testRestPost" method="post">
            <input type="submit" value="testRestPost">
        </form>

        <form action="RequestMappingTest/testRestDelete/1" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="testRestDelete">
        </form>

        <form action="RequestMappingTest/testRestPut/1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="testRestPut">
        </form>

        <a href="RequestMappingTest/testRequestParam?username=username&password=passowrd">testRequestParam</a><br><br>

        <a href="RequestMappingTest/testRequestHeader">testRequestHeader</a><br><br>

        <a href="RequestMappingTest/CookieValue">CookieValue</a><br><br>

        <form action="/RequestMappingTest/testPojo" method="post">
            username:<input type="text" name="username"><br>
            passowrd :<input type="text" name="password"><br>
            age:<input type="text" name="age"><br>
            email:<input type="text" name="email"><br>
            province:<input type="text" name="address.province"><br>
            city:<input type="text" name="address.city"><br>
            <input type="submit" value="SUBMIT">
        </form>

        <a href="RequestMappingTest/testModelAndView">testModelAndView</a><br><br>

        <a href="RequestMappingTest/testMap">testMap</a><br><br>

        <a href="RequestMappingTest/testSessionAttributes">testSessionAttributes</a><br><br>

        <!--
            模拟修改操作
            1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
            2. 密码不能被修改.
            3. 表单回显, 模拟操作直接在表单填写对应的属性值
        -->
        <form action="RequestMappingTest/testModelAttribute" method="Post">
            <input type="hidden" name="id" value="1"/>
            username: <input type="text" name="username" value="Tom"/>
            <br>
            email: <input type="text" name="email" value="tom@atguigu.com"/>
            <br>
            age: <input type="text" name="age" value="12"/>
            <br>
            <input type="submit" value="Submit"/>
        </form><br><br>

        <a href="RequestMappingTest/testView">testView</a><br><br>

        <a href="RequestMappingTest/testRedirect">testRedirect</a><br><br>

    </body>
    </html>
