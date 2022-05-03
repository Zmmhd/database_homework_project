<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/all/css/bootstrap.min.css"/>
    <script src="/all/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="/all/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/all/css/index.css" >
    <style>
        body{
            background-image: url("/all/imagines/beijing.jpg");
            background-repeat: no-repeat;
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-position: center 0;
        }
        #threepart{
            padding-top: 0.5cm;
        }
        .picturewenzi{
            font-size: medium;
            color: #e6d2d5;
        }
    </style>
</head>
<body>
<div class="beijing">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#" style="font-size:x-large">粉墨中国</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
                    <li><a href="/kepu" style="color: #e6d2d5">科普</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="color: #e6d2d5">上海 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">北京</a></li>
                            <li><a href="#">广州</a></li>
                            <li><a href="#">深圳</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">更多热门城市</a></li>
                        </ul>
                    </li>

                    <li><a href="/user/listshow" style="color: #e6d2d5">演出信息</a></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" style="width: 7cm;" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>

                <span class="glyphicon glyphicon-user" aria-hidden="true" style="padding-top:0.5cm;padding-left:5cm;width: 1cm;" ></span>
                <ul class="nav navbar-nav navbar-right">
                    <li>${nickname}</li>
                    <li><a href="/user_main" style="color: #e6d2d5">我的主页</a> </li>
                    <li><a href="/user/logout" style="color: #e6d2d5">退出</a></li>
<%--                    <li><a href="/login" style="color: #e6d2d5">登录</a></li>--%>
<%--                    <li><a href="/register" style="color: #e6d2d5">注册</a></li>--%>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div id="myCarousel" class="carousel" data-ride="carousel" data-interval="4000" >
        <!--图片的容器-->
        <div class="carousel-inner" >
            <div class="item active">
                <a href="/user/userList"><img src="/all/imagines/tao.jpg" style="width: 28cm;height: 8cm" /></a>
            </div>

            <div class="item">
                <img src="/all/imagines/hong.jpg" style="width: 28cm;height: 8cm"/>
            </div>
            <div class="item">
                <img src="/all/imagines/xi.jpeg" style="width: 28cm;height: 8cm">
            </div>
            <div class="item">
                <img src="/all/imagines/mu.jpg" style="width: 28cm;height: 8cm">
            </div>
        </div>

        <!--圆圈指示符-->
        <ol class="carousel-indicators" >
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!--左右的按钮-->
        <a href="#myCarousel" class="left carousel-control" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a href="#myCarousel" class="right carousel-control" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>

    <div class="container">
        <div class="=row" id="threepart">
            <!--        屏幕均分为12格-->
            <div class="col-sm-6 col-md-3" style="text-align: center" >

                <img src="/all/imagines/liang.jpg"
                     alt="图片加载失败..." style="width:220px;height:280px">
                <h3 align="center" class="picturewenzi">梁山伯与祝英台
<%--                    <button class="btn btn-primary " >
                        <span class="glyphicon glyphicon-hand-right" ></span>
                        购票
                    </button>--%>
                </h3>

            </div>
            <div class="col-sm-6 col-md-3"  style="text-align: center">

                <img src="/all/imagines/xi.jpg"
                     alt="图片加载失败..." style="width:220px;height:280px">

                <h3 align="center" class="picturewenzi">
                    西厢记
<%--                    <button class="btn btn-primary">--%>
<%--                        <span class="glyphicon glyphicon-hand-right"></span>--%>
<%--                        购票--%>
<%--                    </button>--%>
                </h3>

            </div>
            <div class="col-sm-6 col-md-3"  style="text-align: center" >

                <img src="/all/imagines/bai.jpg"
                     alt="图片加载失败..." style="width:220px;height:280px">

                <h3 align="center" class="picturewenzi">
                    白蛇传
<%--                    <button class="btn btn-primary">--%>
<%--                        <span class="glyphicon glyphicon-hand-right"></span>--%>
<%--                        购票--%>
<%--                    </button>--%>
                </h3>

            </div>
            <div class="col-sm-6 col-md-3"  style="text-align: center">

                <img src="/all/imagines/ba.jpg" alt="图片加载失败..." style="width:220px;height:280px">

                <h3 align="center" class="picturewenzi">
                    霸王别姬
<%--                    <button class="btn btn-primary" formaction="/user/listshow">--%>
<%--                        <span class="glyphicon glyphicon-hand-right "></span>--%>
<%--                        购票--%>
<%--                    </button>--%>
                </h3>

            </div>
        </div>
    </div>




</div>

</body>
</html>