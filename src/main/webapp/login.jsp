<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
<!--    自适应-->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="/all/css/bootstrap.css">
    <title>login</title>
    <style>
        body{
        background-image: url("/all/imagines/login.jpg");
        opacity:0.85;
        position:absolute;
        width:27cm;
        height:14cm;
        /*min-width: 1000px;*/
        z-index:-10;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        /*-o-background-size: contain;*/
        /*background-position: center 0;*/
        }
        .submit{
            margin-left: 2cm;
            margin-top: 0.5cm;
            width: 3cm;
            height: 1cm;
            border-radius: 7%;
            background: #fc6315;
            color: #f8ebe6;
            border: 2px solid #f8b37f;

        }
        .input-group-addon{
            background: #f9723d;
            color: #f8ebe6;
            border: 2px solid #fa7e23;
            border-radius: 5%;
        }
        .userlogin{
            padding-top: 0.5cm;
        }
        .imgstyle{
            width: 10cm;
            height: 10cm;
            border:4px solid #ebb10d;
        }
        .form-control{
            border: 2px solid #fa7e23;
            border-radius: 5%;
        }
        .submitstyle{
            margin-left: 2cm;
            margin-top: 0.5cm;
            height: 1cm;
            border-radius: 7%;
            background: #fc6315;
            color: #f8ebe6;
            border: 2px solid #f8b37f;
            width: 5cm;
            text-align: center;
            font-size: large;
            color: white;
        }
        .input-group{
            padding-left: 1cm;
            width: 8.5cm;
        }
        .form-control{
            width: 4cm;
        }

    </style>
</head>
<body>
<script src="/all/js/bootstrap.js"></script>
 <div class="container" style="padding-left: 13cm ;padding-top: 1cm;padding-right: 13cm;height: 15cm">
     <img src="/all/imagines/人物.jpg" class="imgstyle">
     <form class="userlogin" role="form" action="/user/login" method="post"  >
         <div class="input-group">
             <span class="input-group-addon" style="color: white">用户名</span>
             <input type="text" class="form-control" name="userId">
         </div>
         <br>
         <div class="input-group">
             <span class="input-group-addon" style="color: white">密码</span>
             <input type="password" class="form-control" name="password">
         </div>
         <input type="submit" class="submitstyle" value="登录">
     </form>
 </div>
</body>
</html>