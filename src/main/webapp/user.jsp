<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/all/css/bootstrap.min.css"/>
    <script src="/all/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="/all/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/all/css/index.css"/>
    <style>
        .list-group-item {
            height: 1cm;
            font-size: large;
            display: block;
            padding: 10px 15px;
            margin-bottom: -1px;
            background-color: #fff;
            border: 1px solid white;
        }
        .imgstyle{
            padding-top: 0.5cm;
            padding-left: 2cm;
            width: 7cm;
            height: 7cm;
        }
        body{
            background-image: url("/all/imagines/beijing.jpg");
            background-repeat: no-repeat;
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-position: center 0;
            opacity: 0.85;
        }
        .beijing{
            background-color: rgb(0 0 0 / 20%);
            width: 100%;
        }
        .nav nav-pills nav-stacked{
            padding-top: 2cm;
        }
        .nav > li > a {
            position: relative;
            display: block;
            padding: 15px 15px;
        }
        img{
            width: 200px;
            height: 200px;
        }
        .member{
            padding-top: 0.5cm;
            padding-left: 1cm;
            width: 260px;
            text-align: center;
            vertical-align: middle;
            color: #ae5454;
            height: 260px;
        }
        .form-control{
            width: 7cm;
        }
        .btn{
            height: 1cm;
            width: 3cm;
            margin-top: 0.5cm
        }
        tr td{
            color: #2b1216;
            font-size: large;
        }
    </style>
    <title>order</title>
</head>
<body>
<div class="beijing">
<div class="container">
    <div class="row">
        <div class="col-md-2 col-md-offset-1" style="background:#131124;height: 20cm">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" ><a href="#grxx" style="color: #e2e1e4;font-size: large" data-toggle="tab">????????????</a></li>
                <li role="presentation" style="color: #e2e1e4;font-size: large" ><a href="#wddd" data-toggle="tab">????????????</a></li>
                <li role="presentation"><a href="#xgmm"style="color: #e2e1e4;font-size: large" data-toggle="tab">????????????</a></li>
                <li role="presentation"><a href="#gywm"style="color: #e2e1e4;font-size: large" data-toggle="tab">????????????</a></li>

            </ul>
        </div>
        <div id="myTabContent" class="tab-content">
            <div class="col-md-9 tab-pane fade in active" id="wddd"style="background:#7c1823;height: 20cm">
                <div class="panel panel-default">
                    <div class="panel-heading" style="background: #7c1823;color:#e2e1e4;font-size: large;border: 2px solid #461629">????????????</div>

                    <div class="row" style="background: #7c1823">
                        <div class="col-md-9 col-md-offset-1">
                            <div class="panel-body">
                                <form action="/user/removeorder" method="post">
                                    <table class="layui-table" style="border:3px solid #36282b;border-radius: 7%;width: 18cm" >
                                        <thead>
                                        <tr class="123" style="background: #30161c;color: #f1c4cd;font-size:large;height: 1.2cm">
                                            <th style="width: 10cm">????????????</th>
                                            <th style="width: 10cm">????????????</th>
                                            <th style="width: 10cm">????????????</th>
                                            <th width="200px" style="width: 10cm">??????</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <!-- ????????????????????????   ????????????c:forEach  items ?????????????????????-->
                                        <c:forEach items="${orderList}" var="t" varStatus="st">
                                            <tr style="background:#63071c;color:#f1c4cd;font-size: large;height: 1.2cm">
                                                <td style="color: #f1c4cd">${t.showName}</td>
                                                <td style="color: #f1c4cd">${t.showTime}</td>
                                                <td style="color: #f1c4cd">${t.seatInfo}</td>
                                                <td>
                                                    <input type="hidden" name="orderId" value="${t.orderId}">
                                                    <input type="submit" value="??????" style="background: #33141e;color:#f1c4cd;border-radius: 4px;width: 2cm;margin-left: 0.5cm">
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </form>

                            </div>
                        </div>
                    </div>

                </div>




            </div>
            <div class="col-md-9 tab-pane fade in active" id="grxx">
                <form style="margin-top: 1cm;margin-left: -10px"  action="/user/modifyuser" method="post">
                    <input type="hidden" name= "userId" value="${userId}">
                    <table class="table" style="color:cornflowerblue">
                        <tbody>
                        <tr>
                            <td>
                                ?????????
                            </td>
                            <td>
                                <input type="text" class="form-control" name="nickname" value="${nickname}" placeholder="???????????????????????????!">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                ???????????????
                            </td>
                            <td>
                                <input type="text" value="${phonenumber}" class="form-control" name="phoneNumber">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                ?????????
                            </td>
                            <td>
                                <input type="text" class="form-control"  value="${email}" name="email">
                            </td>
                        </tr>


                        <tr>
                            <td>
                                ???????????????
                            </td>
                            <td >
                                <input type="text" name="introduction" value="${introduction}"style="color: #f1c4cd;width: 7cm;border-radius: 4px;background: #411c35;border: 2px solid #a7535a;" >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ?????????
                            </td>
                            <td>
                                <input type="text"  name="age" class="form-control" value="${age}">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                ???????????????
                            </td>
                            <td>
                                <input type="text" class="form-control" value="${city}" name="city">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <button type="reset" class="btn btn-default">??????</button>
                            </td>
                            <td style="padding-top: 0.8cm">
                                <input type="submit" value="??????" style="background:#411c35;color:#f1c4cd;border-radius: 4px;width: 3cm;height: 1cm;border: 2px solid #a7535a;font-size: medium">
                            </td>
                        </tr>
                        </tbody>
                    </table>

                </form>
            </div>
            <div class="col-md-9 tab-pane fade" id="xgmm">
                <form  style="margin-left: 4cm;margin-top: 1cm"  action="/user/modifypassword" method="post">
                    <input type="hidden" name="userId" value="${userId}">
                    <table class="table2" style="color: whitesmoke">
                        <tbody>
                        <tr>
                            <td>
                                ????????????
                            </td>
                            <td>
                                <input type="text" class="form-control" name="oldpassword">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                ????????????
                            </td>
                            <td>
                                <input type="text" class="form-control" name="newpassword">
                            </td>
                        </tr>


                        <tr>
                            <td>
                                <button type="reset" class="btn btn-default" >??????</button>
                            </td>
                            <td>
                                <input  type="submit" value="??????" style="background:#411c35;color:#f1c4cd;border-radius: 4px;width: 3cm;margin-top:0.5cm;margin-left: 0.5cm;height: 1cm;border: 2px solid #a7535a;font-size: medium">
                            </td>
                        </tr>

                        </tbody>
                    </table>

                </form>
            </div>
            <div class="col-md-9 tab-pane fade" id="gywm" >
                <div class="row">
                    <h4 style="color:#e2e1e4;">???????????????????????????????????????</h4>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="member">
                            <img src="/all/imagines/syq.jpg" />
                            <h4 style="color:#e2e1e4;font-size: large">?????????????????????????????????</h4>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="member">
                            <img src="/all/imagines/jjx.jpg" />
                            <h4 style="color:#e2e1e4;font-size: large">????????????????????????????????????</h4>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="member">
                            <img src="/all/imagines/yyg.jpg" />
                            <h4 style="color:#e2e1e4;font-size: large">???????????????</h4>
                        </div>
                    </div>
                </div>
                <div class="row" style="padding-top: -1cm">
                    <div class="col-md-3">
                        <div class="member">
                            <img src="/all/imagines/ny.jpg" />
                            <h4 style="color:#e2e1e4;font-size: large">??????????????????</h4>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="member">
                            <img src="/all/imagines/wyy.jpg" />
                            <h4 style="color:#e2e1e4;font-size: large">???????????????</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
</body>
</html>