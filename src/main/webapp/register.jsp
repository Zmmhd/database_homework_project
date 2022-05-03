<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" href="/all/css/register.css">
</head>


<body>
<div class="beijing">
    <div id="loginDiv">
        <form action="/user/register" method="post">
            <h1>注册</h1>

            <p>用户名:&emsp;<input id="userId" name="userId" type="text" autofocus required> <label id="name_trip"></label>
            </p>

            <p>用户密码:<input id="password" name="password" type="password" required><label id="password_trip"></label></p>

<!--            <p>确认密码:<input id="surePassword" name="surepassword" type="password" required><label id="surePassword_trip"></label></p>-->
            <p style="text-align: center;">
<!--                <input type="button" class="button" onclick="submitT()" value="提交">-->
                <input type="submit"  value="提交">
                <input type="reset" class="button" onclick="myFunctionReset()" value="重置">
            </p>
        </form>
    </div>
    <script src="/all/js/jquery.min.js"></script>
    <script src="/all/js/register.js"></script>
</div>
</body>

</html>